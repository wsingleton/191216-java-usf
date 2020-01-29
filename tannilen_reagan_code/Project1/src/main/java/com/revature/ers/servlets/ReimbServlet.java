package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dto.SubmittedReq;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/req")
public class ReimbServlet extends HttpServlet {
    public final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepository());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean successful;
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        try {
            SubmittedReq reimb = mapper.readValue(req.getInputStream(), SubmittedReq.class);
            if (!reimb.getDesc().equals("") && reimb.getDesc() != null) {
                successful=reimbService.submitNewReimbursement(reimb.getAmt(), reimb.getType(), reimb.getDesc(), reimb.getUserID());
            } else {
                successful=reimbService.submitNewReimbursement(reimb.getAmt(), reimb.getType(), reimb.getUserID());
            }
            if (successful) {
                System.out.println("Reimbursement submitted successfully.");
                resp.setStatus(201);
            }

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (Exception e) {
            resp.setStatus(500);
        }
    }
}
