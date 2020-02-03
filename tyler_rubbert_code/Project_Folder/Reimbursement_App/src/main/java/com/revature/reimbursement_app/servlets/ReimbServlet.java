package com.revature.reimbursement_app.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.reimbursement_app.dtos.ErrorResponse;
import com.revature.reimbursement_app.exceptions.ResourcePersistenceException;
import com.revature.reimbursement_app.models.Reimbursement;
import com.revature.reimbursement_app.models.User;
import com.revature.reimbursement_app.repos.ReimbursementRepo;
import com.revature.reimbursement_app.services.ReimbursementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/reimb")
public class ReimbServlet extends HttpServlet {

    private final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepo());
    private static final Logger LOG = LogManager.getLogger(ReimbServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("this-user");

        try {

            LOG.info("Retrieving all reimbursements created by current user");
            Set<Reimbursement> reimbursements = reimbService.getReimbursementsByUserId(currentUser.getId());
            String reimbursementsJSON = mapper.writeValueAsString(reimbursements);
            writer.write(reimbursementsJSON);

        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        try {

            LOG.info("Creating new Reimbursement");
            Reimbursement newReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbService.register(newReimb);
            String newReimbJSON = mapper.writeValueAsString(newReimb);
            writer.write(newReimbJSON);
            resp.setStatus(201);

        } catch(MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        } catch(ResourcePersistenceException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(409);
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch(Exception e) {
            LOG.warn(e.getMessage());
            e.printStackTrace();
        }

    }

}
