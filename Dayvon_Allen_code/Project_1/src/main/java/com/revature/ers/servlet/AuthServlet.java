package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.Credentials;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserService;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    public final UserService userService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        if(req.getSession(false) != null){
            req.getSession().invalidate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = res.getWriter();
        res.setContentType("application/json");

        try {
            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
            User authUser = userService.authenticate(creds.getUsername(),creds.getPassword());
            String authUserJSON = mapper.writeValueAsString(authUser);
            writer.write(authUserJSON);
            HttpSession session = req.getSession();
            session.setAttribute("this-user", authUser);
            System.out.println("[LOG] Authenticated successfully");


        } catch (MismatchedInputException e) {
            res.setStatus(400);
            System.out.println("[ERR] Error");
        } catch (Exception e) {
            res.setStatus(401);
            System.out.println("[ERR] Error");

        } catch (InvalidRequestException e) {
            e.printStackTrace();
            System.out.println("[ERR] Error");
        }
    }
}
