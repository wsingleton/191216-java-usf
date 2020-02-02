package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.exceptions.UnauthorizedRequestException;
import com.revature.ers.models.User;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    public final UserService userService=new UserService(new UserRepository());
    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u=(User) req.getSession().getAttribute("this-user");
        System.out.println("User request received from "+u.getUsername());
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        Set<User> users=new HashSet<>();
        try {
            System.out.println("Attempting to retrieve users.");
            users=userService.findAllUsers(u.getRole());
            System.out.println("Received users from service layer.  Total users: "+users.size());
            String usersJSON=mapper.writeValueAsString(users);
            System.out.println(usersJSON);
            writer.write(usersJSON);
            System.out.println(resp);
        }
        catch (UnauthorizedRequestException e) {
            resp.setStatus(403);
        }
    }
}
