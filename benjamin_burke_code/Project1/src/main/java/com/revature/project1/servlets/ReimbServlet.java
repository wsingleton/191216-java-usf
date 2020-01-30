package com.revature.project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.project1.dtos.ErrorResponse;
import com.revature.project1.exceptions.InvalidRequestException;
import com.revature.project1.exceptions.ResourceNotFoundException;
import com.revature.project1.exceptions.ResourcePersistenceException;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Role;
import com.revature.project1.models.Status;
import com.revature.project1.models.User;
import com.revature.project1.services.ReimbursementService;
import com.revature.project1.services.UserService;
import repos.ReimbursementRepository;
import repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;

@WebServlet ("/reimbs")
public class ReimbServlet extends HttpServlet {

    private final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String reimbParam = req.getParameter("reimbId");
        resp.setContentType("application/JSON");
        User user = (User) req.getSession().getAttribute("this-user");
        System.out.println(user);
        if (reimbParam == null) {
            System.out.println("reimbParam null");
            if (user.getRole() == Role.ADMIN || user.getRole() == Role.MANAGER){

                Set<Reimbursement> reimbs = reimbService.getAllReimb();
                String reimbsJSON = mapper.writeValueAsString(reimbs);
                resp.getWriter().write(reimbsJSON);

            }
            else {
                System.out.println("not an admin");
                Set<Reimbursement> reimbs = reimbService.getReimbByUser(user.getId());
                String reimbsJSON = mapper.writeValueAsString(reimbs);
                resp.getWriter().write(reimbsJSON);
            }
        }
        else {
            try {
                Reimbursement reimb = reimbService.getReimbById((Integer.parseInt(reimbParam)));
                String reimbJSON = mapper.writeValueAsString(reimb);
                resp.getWriter().write(reimbJSON);
            } catch (Exception e) {
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
            Reimbursement newReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbService.saveReimb(newReimb);
            String newReimbJSON = mapper.writeValueAsString(newReimb);
            writer.write(newReimbJSON);
                System.out.println(newReimb);


                resp.setStatus(201); // created

        }catch (MismatchedInputException e) {
            e.printStackTrace();
            resp.setStatus(400); // bad request
        } catch(ResourceNotFoundException e) {
            resp.setStatus(409); // conflict
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(500); // internal server error
        }

    }

//    @Override
//    protected void doPut(HttpServletRequest req ,HttpServletResponse resp) throws ServletException, IOException {
//
//        resp.setContentType("application/json");
//        ObjectMapper mapper = new ObjectMapper();
//        PrintWriter writer = resp.getWriter();
//        User user = (User) req.getSession().getAttribute("this-user");
//
//        try {
//            Reimbursement updateReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
//            updateReimb.setResolverId(user.getId());
//            reimbService.updateReimbursement(updateReimb);
//            String updatedReimbJSON = mapper.writeValueAsString(updateReimb);
//            resp.setStatus(202); // accepted
//
//        } catch (MismatchedInputException e) {
//            resp.setStatus(400);
//        } catch (InvalidRequestException e) {
//
//        }
//    }

}
