package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.dtos.StatusUpdate;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repos.ReimbRepository;
import com.revature.repos.UserRepository;
import com.revature.services.ReimbService;

import javax.security.sasl.AuthenticationException;
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
    public final ReimbService reimbService = new ReimbService(new ReimbRepository());
    public final UserRepository uRepo = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("this-user");

        if (user.getRole() == Role.FINANCE_MANAGER) {
            Set<Reimbursement> reimb =  reimbService.getAllReimb();
            String reimbJSON = mapper.writeValueAsString(reimb);
            resp.getWriter().write(reimbJSON);
        } else {
            try {
                Set<Reimbursement> reimb = reimbService.getByAuthorId(user.getId());
                String reimbJSON = mapper.writeValueAsString(reimb);
                resp.getWriter().write(reimbJSON);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("this-user");


        try {
            Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            System.out.println(reimb.getAmount());
            System.out.println(reimb.getDescription());
            System.out.println(reimb.getCategoryId());
            reimb.setAuthId(user.getId());
            reimbService.addReimbReq(reimb);

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json");

        try {
            StatusUpdate transfer = mapper.readValue(req.getInputStream(), StatusUpdate.class);
            Reimbursement reimbursement = new Reimbursement();
            reimbursement.setId(transfer.getId());
            reimbursement.setStatusId(Status.getById(transfer.getStatusId()));
            System.out.println(reimbursement);
            reimbService.update(reimbursement);
        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (ResourceNotFoundException e){
            resp.setStatus(401);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
