package com.revature.project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.project1.models.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deny")
public class DenyServlet extends HttpServlet {

    public final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepo());

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {

            Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimb.setStatus(ReimbursementStatus.DENIED);
            reimbService.updateReimbursement(reimb);
            resp.setStatus(201);

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (Exception e) {
            resp.setStatus(500);
        }

    }

}
