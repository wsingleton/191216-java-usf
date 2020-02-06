package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dto.Credentials;
import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserService;

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
    public final UserService userService=new UserService(new UserRepository());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        try {
            Credentials creds=mapper.readValue(req.getInputStream(), Credentials.class);
            User authUser=userService.authenticate(creds.getUsername(), creds.getPassword());
            System.out.println(authUser);
            String authUserJSON=mapper.writeValueAsString(authUser);
            writer.write(authUserJSON);
            HttpSession session = req.getSession();
            session.setAttribute("this-user", authUser);
        }
        catch (MismatchedInputException e) {
            resp.setStatus(400);
        }
        catch (AuthenticationException e) {
            resp.setStatus(401);
        }
        catch (Exception e) {
            resp.setStatus(500);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Logout function in Auth Servlet called.");
        if(req.getSession(false) != null) {
            req.getSession().invalidate();
        }
    }
}