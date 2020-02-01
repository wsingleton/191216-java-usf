package com.revature.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import com.revature.models.Reimbursement;

import com.revature.models.ReimbursementStatus;
import com.revature.repos.ReimbursementRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/approve")
public class ApproveServlet extends HttpServlet {
    public final ReimbursementRepository reimbursementRepository = new ReimbursementRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {
            Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbursement.setReimbursementStatusId(ReimbursementStatus.APPROVED);
            reimbursementRepository.update(reimbursement);
            resp.setStatus(201);
            System.out.println("[LOG] Approved successfully");
        } catch (MismatchedInputException e) {
            System.out.println("[ERR] Error");
            resp.setStatus(400);
        } catch (Exception e) {
            System.out.println("[ERR] Error");
            resp.setStatus(500);
            e.printStackTrace();
        }
    }
}
