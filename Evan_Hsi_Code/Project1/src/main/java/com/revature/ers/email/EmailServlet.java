package com.revature.ers.email;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.User;
import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.UserService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmailServlet", urlPatterns = {"/confirmation"})
public class EmailServlet extends HttpServlet {

    private final UserService userService = new UserService(new UserRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String userIdParam = req.getParameter("user_id");
        resp.setContentType("text/html");


        try {

            if(userIdParam != null) {
                int id = Integer.parseInt(userIdParam);
                userService.confirmAccount(id);

                resp.sendRedirect("/project1");
            }
            else throw new InvalidRequestException();

        } catch (Exception e) {
            resp.setStatus(400);
            e.printStackTrace();
        }

    }
}
