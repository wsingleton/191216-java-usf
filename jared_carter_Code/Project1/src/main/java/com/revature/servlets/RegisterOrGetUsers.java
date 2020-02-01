package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.expections.InvalidRequestException;
import com.revature.expections.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;


import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@WebServlet("/register")
public class RegisterOrGetUsers extends HttpServlet {

    public final UserService userService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        String userIdParam = req.getParameter("userId");

        if (req.getSession(false) != null) {
            User thisUser = (User) req.getSession().getAttribute("this-user");
            System.out.println(thisUser);
        }

        if (userIdParam == null) {

            Set<User> users = userService.getAllUsers();
            String usersJSON = mapper.writeValueAsString(users);
            resp.getWriter().write(usersJSON);

        } else {

            try {
                User user = userService.getUserById(Integer.parseInt(userIdParam));
                String userJSON = mapper.writeValueAsString(user);
                resp.getWriter().write(userJSON);

            } catch (Exception e) {
                resp.setStatus(400);
            }

        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {
            User user = mapper.readValue(req.getInputStream(), User.class);
            userService.register(user);
            resp.setStatus(201);
            System.out.println("[LOG] Registered successfully");
        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401);
        } catch (Exception e) {
            resp.setStatus(500);
//        } catch (InvalidRequestException e) {
//            e.printStackTrace();
//        } catch (ResourcePersistenceException e) {
//            resp.setStatus(409);
//            e.printStackTrace();
//        }
        }

    }
}