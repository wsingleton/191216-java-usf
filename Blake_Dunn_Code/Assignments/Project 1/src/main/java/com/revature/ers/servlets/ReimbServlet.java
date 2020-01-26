package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.models.Reimbursement;
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
        String typeParam = req.getParameter("type");
        resp.setContentType("application/JSON");

        if (typeParam == null) {
            Set<Reimbursement> reimbs = reimbService.getAllReimbs();
            String reimbsJSON = mapper.writeValueAsString(reimbs);
            resp.getWriter().write(reimbsJSON);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        try {

            Reimbursement newReimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbService.saveReimb(newReimb);
            String newReimbJSON = mapper.writeValueAsString(newReimb);
            resp.setStatus(201); // created

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
