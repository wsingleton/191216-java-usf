package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.User;
import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService(new UserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {

            User user = mapper.readValue(req.getInputStream(), User.class);
            userService.register(user);
            String authUserJSON = mapper.writeValueAsString(user);
            writer.write(authUserJSON);
            System.out.println(authUserJSON);
            HttpSession session = req.getSession();
            session.setAttribute("this-user", user);


        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (ResourcePersistenceException e) {
            resp.setStatus(401);
        } catch (Exception e) {
            resp.setStatus(500);
        }
        resp.setStatus(201);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
