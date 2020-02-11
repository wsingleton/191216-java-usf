package com.revature.quizzard.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.quizzard.dtos.ErrorResponse;
import com.revature.quizzard.exceptions.ResourcePersistenceException;
import com.revature.quizzard.models.User;
import com.revature.quizzard.repos.UserRepository;
import com.revature.quizzard.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;
import java.util.Set;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {


        String userIDParam = req.getParameter("userId");
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        if (req.getSession(false) != null) {
            User thisUser = (User) req.getSession().getAttribute("this-user");
            System.out.println(thisUser);
        }

        if(userIDParam == null) {
            Set<User> users = userService.getAllUsers();

            String usersJSON = mapper.writeValueAsString(users);
            resp.getWriter().write(usersJSON);

        } else {

            try {
                User user = userService.getUserById(Integer.parseInt(userIDParam));
                String userJSON = mapper.writeValueAsString(user);
                resp.getWriter().write(userJSON);
            } catch (Exception e) {
                resp.setStatus(400);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        try {

            User newUser = mapper.readValue(req.getInputStream(), User.class);
            userService.register(newUser);
            String newUserJSON = mapper.writeValueAsString(newUser);
            writer.write(newUserJSON);
            resp.setStatus(201);

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (ResourcePersistenceException e) {
            resp.setStatus(409);
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            writer.write(mapper.writeValueAsString(err));
        }catch (Exception e) {
            resp.setStatus(500);
        }
    }
}