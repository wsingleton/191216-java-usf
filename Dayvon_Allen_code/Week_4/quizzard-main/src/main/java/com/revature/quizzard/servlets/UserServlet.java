package com.revature.quizzard.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.quizzard.dtos.ErrorResponse;
import com.revature.quizzard.exceptions.InvalidRequestException;
import com.revature.quizzard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.exceptions.ResourcePersistenceException;
import com.revature.quizzard.models.User;
import com.revature.quizzard.repos.UserRepository;
import com.revature.quizzard.services.UserService;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Set<User> users = null;

        String userIdParam = req.getParameter("userId");
        ObjectMapper mapper = new ObjectMapper();
        res.setContentType("application/json");

        if(req.getSession(false) != null) {
            User thisUser = (User) req.getSession().getAttribute("this-user");
            System.out.println(thisUser);
        }

        if(userIdParam == null){
            try {
                users = userService.getAllUsers();
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
            String usersJSON = mapper.writeValueAsString(users);
            res.getWriter().write(usersJSON);
            res.setContentType("application/json");
        }
        else {
            try{
                User user = userService.getUserById(Integer.parseInt(userIdParam));
                String userJSON = mapper.writeValueAsString(user);
                res.getWriter().write(userJSON);
            } catch (Exception | ResourceNotFoundException e){
                res.setStatus(400);
            }
        }


    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = res.getWriter();
        res.setContentType("application/json");

        try {
            User user = mapper.readValue(req.getInputStream(), User.class);
            userService.register(user);
            String newUserJSON = mapper.writeValueAsString(user);
            writer.write(newUserJSON);
            res.setStatus(201);

        } catch (MismatchedInputException e) {
            res.setStatus(400);
        } catch (AuthenticationException e) {
            res.setStatus(401);
        }
        catch (Exception e) {
            res.setStatus(500);
        }  catch (ResourcePersistenceException e) {
             res.setStatus(409);
             ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
             err.setMessage("User already exists!");
             writer.write(mapper.writeValueAsString(err));

        } catch (InvalidRequestException e) {
            e.printStackTrace();
        }
    }
}
