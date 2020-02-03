package com.ers.liberation.serverlets;

import com.ers.liberation.dtos.ErrorResponse;
import com.ers.liberation.exceptions.InvalidRequestException;
import com.ers.liberation.exceptions.ResourcePersistenceException;
import com.ers.liberation.models.Reimbursement;
import com.ers.liberation.models.Role;
import com.ers.liberation.models.User;
import com.ers.liberation.repos.ReimbursementRepository;
import com.ers.liberation.services.ReimbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
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

@WebServlet("/reimbursements/*")
public class ReimbServlet extends HttpServlet {
    private final ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementRepository());
    private static final Logger LOG = LogManager.getLogger(ReimbServlet.class);

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        resp.setContentType("application/json");


        User thisUser = (User) req.getSession().getAttribute("this-user");
        LOG.info("User session has been acquired and set to a User object ");

        try {
            Reimbursement updatedReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            updatedReimb.setResolverId(thisUser.getId());
            LOG.info("Resolver Id Appended");
            reimbursementService.updateReimbursement(updatedReimb);
            LOG.info("Reimbursement updated successfully");
            resp.setStatus(201);

        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        } catch (ResourcePersistenceException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(409);
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch (Exception e) {
            LOG.error(e.getMessage());
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        resp.setContentType("application/json");

        try {
            Reimbursement newReimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);

            User thisUser = (User) req.getSession().getAttribute("this-user");
            LOG.info("User session has been acquired and set to a User object ");
            System.out.println(thisUser);
            newReimbursement.setAuthorId(thisUser.getId());
            LOG.info("Current user's Id Appended as Author Id");
            reimbursementService.addNewReimbursement(newReimbursement);
            LOG.info("Reimbursement Added Successfully");
            resp.setStatus(201);
        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        } catch (InvalidRequestException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(409);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            resp.setStatus(500);
        }

    }

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
//        String reimbParam = req.getParameter("reimbId");
        PrintWriter writer = resp.getWriter();

        resp.setContentType("application/json");
        User thisUser = (User) req.getSession().getAttribute("this-user");


            if (thisUser.getRole().getId() == 1 || thisUser.getRole() == Role.EMPLOYEE) {
                Set<Reimbursement> reimbursements = reimbursementService.getReimbursements4Employee(thisUser);
                resp.getWriter().write(mapper.writeValueAsString(reimbursements));

            } else if (thisUser.getRole().getId() == 2 || thisUser.getRole() == Role.FINANCE_MANAGER) {
                Set<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
                resp.getWriter().write(mapper.writeValueAsString(reimbursements));

            } else {
                Set<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
                resp.getWriter().write(mapper.writeValueAsString(reimbursements));
            }


        }

    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ObjectMapper mapper = new ObjectMapper();
////        String reimbParam = req.getParameter("reimbId");
//        PrintWriter writer = resp.getWriter();
//
//        resp.setContentType("application/json");
//        User thisUser = (User) req.getSession().getAttribute("this-user");
//
//
//
////            Set<Reimbursement> reimbursements = reimbursementService.getReimbursements4Employee(thisUser);
////            resp.getWriter().write(mapper.writeValueAsString(reimbursements));
//
//
//            Set<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
//            resp.getWriter().write(mapper.writeValueAsString(reimbursements));
//
////        } else {
////            Set<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
////            resp.getWriter().write(mapper.writeValueAsString(reimbursements));
////        }
//
//
//    }





