package com.revature.servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.exceptions.ResourcePersistenceException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;
import sun.net.www.protocol.jar.URLJarFile;

import javax.jws.soap.SOAPBinding;
import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
    public final UserService uService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String userId = req.getParameter("ers_user_id");
        resp.setContentType("application/json");

        if (req.getSession(false) != null) {
            User currentUser = (User) req.getSession().getAttribute("this-user");
        } if (userId == null) {
            Set<User> users = uService.getAllUsers();
            String usersJSON = mapper.writeValueAsString(users);
            resp.getWriter().write(usersJSON);
        }

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
