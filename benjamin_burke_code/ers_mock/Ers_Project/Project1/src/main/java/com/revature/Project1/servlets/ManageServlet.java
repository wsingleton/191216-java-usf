package com.revature.Project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.reimbursement_app.dtos.ErrorResponse;
import com.revature.reimbursement_app.exceptions.ResourcePersistenceException;
import com.revature.reimbursement_app.models.Reimbursement;
import com.revature.reimbursement_app.models.ReimbursementStatus;
import com.revature.reimbursement_app.repos.ReimbursementRepo;
import com.revature.reimbursement_app.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/manage")
public class ManageServlet extends HttpServlet {

    private final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepo());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {

            Set<Reimbursement> reimbursements = reimbService.getReimbursementsByStatus(ReimbursementStatus.PENDING);
            String reimbursementsJSON = mapper.writeValueAsString(reimbursements);
            resp.getWriter().write(reimbursementsJSON);

        } catch(Exception e) {
            resp.setStatus(400);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        try {

            Reimbursement updatedReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbService.updateReimbursement(updatedReimb);
            String updatedReimbJSON = mapper.writeValueAsString(updatedReimb);
            writer.write(updatedReimbJSON);
            resp.setStatus(201);

        } catch(MismatchedInputException e) {
            resp.setStatus(400);
        } catch(ResourcePersistenceException e) {
            resp.setStatus(409);
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
