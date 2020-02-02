package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.User;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReimbursementStatusServlet extends HttpServlet {



    public final ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementRepository());
    public final UserRepository userRepository = new UserRepository()

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("this-user");

        if(reim)
    }

}
