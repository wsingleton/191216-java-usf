package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repos.ReimbursementRepository;
import com.revature.repos.UserRepository;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{


    static UserService userServ = new UserService();
    static ReimbursementService reimServ = new ReimbursementService();
    static ReimbursementRepository rRepo = new ReimbursementRepository();
    static UserRepository uRepo = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("partials/login.html").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        User u = mapper.readValue(req.getInputStream(), User.class);
        u = userServ.authenticate(u.getUsername(), u.getPassword());

        if(u == null) {

            req.getRequestDispatcher("partials/error-login.html").forward(req, resp);

        }

        else {

            HttpSession session = req.getSession();
            session.setAttribute("user", u);

            if(u.getId() == 2) {

                resp.sendRedirect("partials/employee.html");

            }
            else {

                resp.sendRedirect("partials/manager.html");

            }


        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();

        Reimbursement r = mapper.readValue(req.getInputStream(), Reimbursement.class);
        //want to update status



    }

}
