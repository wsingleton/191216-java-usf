package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet ("/reimbs/*")
public class ReimbServlet extends HttpServlet {

    private final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepository());
    private static final Logger LOG = LogManager.getLogger(ReimbServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String reimbParam = req.getParameter("reimbId");
        resp.setContentType("application/JSON");
        User user = (User) req.getSession().getAttribute("this-user");

        if (reimbParam == null) {

            if (user.getRole() == Role.ADMIN || user.getRole() == Role.MANAGER){

                LOG.info("Manager, {}, is attempting to retrieve all pending requests.", user.getUsername());
                Set<Reimbursement> reimbs = reimbService.getAllReimbs();
                resp.getWriter().write(mapper.writeValueAsString(reimbs));

            }
            else {
                LOG.info("User, {}, is attempting to retrieve request history.", user.getUsername());
                Set<Reimbursement> reimbs = reimbService.getReimbByUser(user.getUserId());
                resp.getWriter().write(mapper.writeValueAsString(reimbs));
            }
        }
        else {
            try {
                LOG.info("User, {}, is attempting to view a specific request.", user.getUsername());
                Reimbursement reimb = reimbService.getReimbById((Integer.parseInt(reimbParam)));
                resp.getWriter().write(mapper.writeValueAsString(reimb));
            } catch (Exception e) {
                LOG.warn(e.getMessage());
                resp.setStatus(400);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        User user = (User) req.getSession().getAttribute("this-user");

        try {
            LOG.info("A new reimbursement request was made by, {}", user.getUsername());
            Reimbursement newReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);

            if (user.getRole() == Role.EMPLOYEE) {
                newReimb.setAuthorId(user.getUserId());
                System.out.println(newReimb);
                reimbService.saveReimb(newReimb);
                String newReimbJSON = mapper.writeValueAsString(newReimb);
                LOG.info("Request submission was successful!");
                resp.setStatus(201); // created
            }

        }catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400); // bad request
        } catch(ResourceNotFoundException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(409); // conflict
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch(InvalidRequestException e) {
            LOG.error(e.getMessage());
            resp.setStatus(401);
        } catch(Exception e) {
            LOG.error(e.getMessage());
            resp.setStatus(500); // internal server error
        }

    }

    @Override
    protected void doPut(HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        User user = (User) req.getSession().getAttribute("this-user");

        try {

            Reimbursement updateReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            LOG.info("Submitting updated reimbursement request with Id:, {}", updateReimb.getReimbId());

            LOG.info("Adding resolver id, {}, to reimbursement with id, {}", user.getUserId(), updateReimb.getReimbId());
            updateReimb.setResolverId(user.getUserId());

            reimbService.updateReimbursement(updateReimb);
            LOG.info("Update submission was successful!");

            String updatedReimbJSON = mapper.writeValueAsString(updateReimb);
            resp.setStatus(202); // accepted

        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        } catch (InvalidRequestException e) {
            LOG.error(e.getMessage());
        }
    }

}
