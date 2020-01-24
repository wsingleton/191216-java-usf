package com.revature.quizzard.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.quizzard.dtos.Credentials;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try{

            if (req.getSession(false) != null) {
                User thisUser = (User) req.getSession().getAttribute("this-user");
                System.out.println(thisUser);
            }

            Set<User> users = userService.getAllUsers();
            String usersJSON = mapper.writeValueAsString(users);
            writer.write(usersJSON);

        } catch(Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try{
            User newUser = mapper.readValue(req.getInputStream(), User.class);
            userService.register(newUser);

            String newUserJSON = mapper.writeValueAsString(newUser);
            writer.write(newUserJSON);
            resp.setStatus(201); // 201 means created.

        }catch(MismatchedInputException e){
            resp.setStatus(400); // 400 bad request
        }catch(AuthenticationException e)
        {
            resp.setStatus(409);// conflict bcz the user is already taken
        } catch (Exception e){
            resp.setStatus(500); // internal server error
        }
    }
}
