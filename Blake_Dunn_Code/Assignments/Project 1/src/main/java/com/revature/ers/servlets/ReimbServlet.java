package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.ReimbursementStatus;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repos.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String reimbParam = req.getParameter("reimbId");
        resp.setContentType("application/JSON");
        User user = (User) req.getSession().getAttribute("this-user");

        if (reimbParam == null) {
            if (user.getRole() == Role.ADMIN || user.getRole() == Role.MANAGER){

                Set<Reimbursement> reimbs = reimbService.getAllReimbs();
                String reimbsJSON = mapper.writeValueAsString(reimbs);
                resp.getWriter().write(reimbsJSON);

            }else {

                Set<Reimbursement> reimbs = reimbService.getReimbByUser(user.getUserId());
                String reimbsJSON = mapper.writeValueAsString(reimbs);
                resp.getWriter().write(reimbsJSON);
            }
        }else {
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
            if (user.getRole() == Role.EMPLOYEE) {
                Reimbursement newReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
                newReimb.setAuthorId(user.getUserId());
                reimbService.saveReimb(newReimb);
                String newReimbJSON = mapper.writeValueAsString(newReimb);
                resp.setStatus(201); // created
            }
            else {
                Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
                reimb.setResolverId(user.getUserId());
                reimbService.updateReimbursement(reimb);
                String updatedReimbJSON = mapper.writeValueAsString(reimb);
                resp.setStatus(202); // accepted
            }

        }catch (MismatchedInputException e) {
            resp.setStatus(400); // bad request
        } catch(ResourceNotFoundException e) {
            resp.setStatus(409); // conflict
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch(Exception e) {
            resp.setStatus(500); // internal server error
        }

    }

}
