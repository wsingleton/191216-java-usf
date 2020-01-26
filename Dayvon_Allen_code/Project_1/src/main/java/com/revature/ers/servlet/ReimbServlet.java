package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Role;
import com.revature.ers.models.Status;
import com.revature.ers.models.User;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.ReimbursementService;
import com.revature.ers.services.UserService;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/reimb")
public class ReimbServlet extends HttpServlet {

    public final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepository());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        res.setContentType("application/json");
        Set<Reimbursement> reimb = reimbService.getAllReimbursements();
        String reimbJSON = mapper.writeValueAsString(reimb);
        res.getWriter().write(reimbJSON);
        System.out.println("[LOG] Successfully sent response");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        res.setContentType("application/json");
        try {
            Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimb.setStatusId(Status.getById(1));
            reimbService.createReimbursement(reimb);
            res.setStatus(201);
            System.out.println("[LOG] Created successfully");

        } catch (MismatchedInputException e) {
            res.setStatus(400);
            System.out.println("[ERR] Error");
        }
        catch (Exception e) {
            res.setStatus(500);
            System.out.println("[ERR] Error");
        }
    }
}
