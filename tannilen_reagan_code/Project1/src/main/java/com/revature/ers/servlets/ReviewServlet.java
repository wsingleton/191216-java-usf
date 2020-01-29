package com.revature.ers.servlets;

import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    public final ReimbursementService reimbService=new ReimbursementService(new ReimbursementRepository());
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //logic for posting approvals or rejections
    }
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //logic for checking the type of user making the request, then requesting all reimbursements relevant
    }
}
