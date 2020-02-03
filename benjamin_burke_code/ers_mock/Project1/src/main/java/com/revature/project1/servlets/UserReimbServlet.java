package com.revature.project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.project1.dtos.ErrorResponse;
import com.revature.project1.exceptions.ResourcePersistenceException;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.User;
import com.revature.project1.repos.ReimbursementRepository;
import com.revature.project1.repos.UserRepository;
import com.revature.project1.services.ReimbursementService;
import com.revature.project1.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/userreimb")

public class UserReimbServlet extends HttpServlet {

    private final UserService userService = new UserService(new UserRepository());
    private final ReimbursementService userReimbursement = new ReimbursementService(new ReimbursementRepository());


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        try {
            Reimbursement newReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);

            userReimbursement.getReimbById(newReimb.getId());
            String newUserJSON = mapper.writeValueAsString(newReimb);
            writer.write(newUserJSON);
            resp.setStatus(201);

        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (ResourcePersistenceException e) {
            resp.setStatus(409);
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch (Exception e) {
            resp.setStatus(500);
        }
    }
}

