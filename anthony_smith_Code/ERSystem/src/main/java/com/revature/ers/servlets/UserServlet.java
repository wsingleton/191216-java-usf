package com.revature.ers.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserServices;
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
    private final UserServices userService = new UserServices(new UserRepository());

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
                User user = userService.getUserByID(Integer.parseInt(userIdParam));
                String userJSON = mapper.writeValueAsString(user);
                resp.getWriter().write(userJSON);
            } catch (Exception e) {
                resp.setStatus(400);
            }
        }
    }


}