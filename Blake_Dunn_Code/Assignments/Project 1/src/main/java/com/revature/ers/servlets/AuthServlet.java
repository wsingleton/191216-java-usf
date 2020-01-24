package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.Credentials;
import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    public final
    UserService userService = new UserService(new UserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");


        try {

            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
            User authUser = userService.authenticate(creds.getUsername(), creds.getPassword());
            String authUserJSON = mapper.writeValueAsString(authUser);
            writer.write(authUserJSON);

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        }catch (AuthenticationException e) {
            resp.setStatus(420);
        }catch (Exception e) {
            resp.setStatus(500);
            e.printStackTrace();
        }

    }
}
