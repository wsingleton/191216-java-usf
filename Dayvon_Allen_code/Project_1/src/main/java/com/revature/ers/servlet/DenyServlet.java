package com.revature.ers.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deny")
public class DenyServlet extends HttpServlet {
    public final ReimbursementRepository reimbRepo = new ReimbursementRepository();

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        res.setContentType("application/json");

        try {
            Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimb.setStatusId(Status.DENIED);
            reimbRepo.update(reimb);
            res.setStatus(201);
        } catch (MismatchedInputException e) {
            res.setStatus(400);
        } catch (Exception e) {
            res.setStatus(500);
        }

    }
}
