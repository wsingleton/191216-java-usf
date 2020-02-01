package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;
import com.revature.repos.ReimbursementRepository;
import com.revature.repos.UserRepository;
import com.revature.services.ReimbursementService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

@WebServlet("/reimb")
public class ReimbursementServlet extends HttpServlet {

    public final ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementRepository());
    public final UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        Set<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
        Set<User> users = userRepository.findAll();
        String reimbJSON = mapper.writeValueAsString(reimbursements);
        String userJSON = mapper.writeValueAsString(users);
        String[] data = {reimbJSON, userJSON};
        resp.getWriter().write(Arrays.toString(data));
        System.out.println("[LOG] Successfully sent response");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        try {
            Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbursement.setReimbursementStatusId(ReimbursementStatus.getReimbursementStatusById(1));
            reimbursementService.newReimbursement(reimbursement);
            resp.setStatus(201);
            System.out.println("[LOG] Created successfully");

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
            System.out.println("[ERR] Error");
        } catch (Exception e) {
            resp.setStatus(500);
            System.out.println("[ERR] Error");
        }
    }
}
