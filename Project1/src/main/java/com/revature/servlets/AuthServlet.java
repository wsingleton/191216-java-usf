package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class AuthServlet extends HttpServlet {
    private final UserService uService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String userId = req.getParameter("ers_user_id");
        resp.setContentType("application/json");

        try {
                User user = uService.getUserById(Integer.parseInt(userId));
                String userJSON = mapper.writeValueAsString(user);
                resp.getWriter().write(userJSON);
            } catch (ResourceNotFoundException e) {
                resp.setStatus(400);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {
            User user = mapper.readValue(req.getInputStream(), User.class);
            uService.registration(user);
            String userJSON = mapper.writeValueAsString(user);
            writer.write(userJSON);
            HttpSession session = req.getSession();
            session.setAttribute("this-user", user);
            resp.setStatus(201);
        } catch (MismatchedInputException e) {
            resp.setStatus(400);
            System.err.println("ERROR");
        } catch (ResourcePersistenceException e) {
            resp.setStatus(409);
        }
    }

}
