package com.revature.servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserServlet extends HttpServlet {
    public final UserService uService = new UserService(new UserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {
            User user = mapper.readValue(req.getInputStream(), User.class);
            uService.registration(user);
            resp.setStatus(201);
            System.out.println("registration successful");
        } catch (MismatchedInputException e) {
            resp.setStatus(400);
            System.err.println("ERROR");
        } catch (AuthenticationException e) {
            resp.setStatus(401);
            System.err.println("INVALID INPUTS");
        } catch (ResourcePersistenceException e) {
            resp.setStatus(409);
        } catch (Exception e) {
            resp.setStatus(500);
            System.err.println("an unexpected error has occurred");
        }
    }
}
