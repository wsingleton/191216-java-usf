package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.repos.ReimbursementRepository;
import com.revature.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/denied")
public class DenyServlet extends HttpServlet {

    public final ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementRepository());

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {

            Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbursement.setReimbursementStatusId(ReimbursementStatus.DENIED);
            reimbursementService.update(reimbursement);
            resp.setStatus(201);

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (Exception e) {
            resp.setStatus(500);
        }

    }

}