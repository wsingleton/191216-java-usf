package com.revature.reimbursement_app.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.reimbursement_app.dtos.ErrorResponse;
import com.revature.reimbursement_app.exceptions.ResourcePersistenceException;
import com.revature.reimbursement_app.models.Reimbursement;
import com.revature.reimbursement_app.models.User;
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

@WebServlet("/reimb")
public class ReimbServlet extends HttpServlet {

    private final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepo());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {

            User currentUser = (User) req.getSession().getAttribute("this-user");
            Set<Reimbursement> reimbursements = reimbService.getReimbursementsByUser(currentUser);

        } catch (Exception e) {
            resp.setStatus(400);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        try {

            Reimbursement newReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbService.register(newReimb);
            String newReimbJSON = mapper.writeValueAsString(newReimb);
            writer.write(newReimbJSON);
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
