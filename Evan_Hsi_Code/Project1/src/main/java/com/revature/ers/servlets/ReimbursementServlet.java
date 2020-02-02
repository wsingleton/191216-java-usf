package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.NewReimbursement;
import com.revature.ers.dtos.UpdateReimbursement;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.User;
import com.revature.ers.repositories.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class ReimbursementServlet extends HttpServlet {
    private final ReimbursementService rServ = new ReimbursementService(new ReimbursementRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {

            User user = (User) req.getSession(false).getAttribute("this-user");

            System.out.println("ReimbServlet");

            NewReimbursement temp = mapper.readValue(req.getInputStream(), NewReimbursement.class);

            System.out.println("Mapped");
            System.out.println(temp.getDescription());


            Reimbursement newReimb = new Reimbursement(temp.getAmount(), temp.getDescription(), temp.getReceipt(), temp.getType());
            newReimb.setSubmitId(user.getId());
            rServ.create(newReimb);
            writer.write(mapper.writeValueAsString(user.getRole().getId()));

        } catch (Exception e) {
            resp.setStatus(400);
            e.printStackTrace();
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {

            UpdateReimbursement update = mapper.readValue(req.getInputStream(), UpdateReimbursement.class);
            Reimbursement dummy = new Reimbursement();
            dummy.setId(update.getId());
            if(update.getStatus().equals("approve")) {
                dummy.setStatus(Status.APPROVED);
            }
            else dummy.setStatus(Status.DENIED);
            rServ.update(dummy);

        } catch (Exception e) {
            resp.setStatus(400);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {

            Set<Reimbursement> reimbs = rServ.getAllReimbursements();
            String reimbJSON = mapper.writeValueAsString(reimbs);
            writer.write(reimbJSON);

        } catch (Exception e) {
            resp.setStatus(400);
            e.printStackTrace();
        }
    }
}
