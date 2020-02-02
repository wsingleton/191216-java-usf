package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.NewReimbursement;
import com.revature.ers.dtos.UpdateReimbursement;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Status;
import com.revature.ers.models.User;
import com.revature.ers.repositories.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private static final Logger LOG = LogManager.getLogger(ReimbursementServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {

            User user = (User) req.getSession(false).getAttribute("this-user");
            NewReimbursement temp = mapper.readValue(req.getInputStream(), NewReimbursement.class);

            LOG.info("Creating new reimbursement");

            Reimbursement newReimb = new Reimbursement(temp.getAmount(), temp.getDescription(), temp.getReceipt(), temp.getType());
            newReimb.setSubmitId(user.getId());
            rServ.create(newReimb, user);
            writer.write(mapper.writeValueAsString(user.getRole().getId()));

        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
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
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("this-user");

            LOG.info("Updating reimbursement with id {}", dummy.getId());

            if(update.getStatus().equals("approve")) {
                LOG.info("Approving reimbursement");
                dummy.setStatus(Status.APPROVED);
            }
            else {
                LOG.info("Denying reimbursement");
                dummy.setStatus(Status.DENIED);
            }

            LOG.info("Pushing update to database");
            rServ.update(dummy, user);

        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("this-user");
        int userid = user.getId();

        try {

            LOG.info("Retrieving all reimbursements");

            Set<Reimbursement> reimbs = rServ.getAllBut(userid, user);
            String reimbJSON = mapper.writeValueAsString(reimbs);
            writer.write(reimbJSON);

        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        }
    }
}
