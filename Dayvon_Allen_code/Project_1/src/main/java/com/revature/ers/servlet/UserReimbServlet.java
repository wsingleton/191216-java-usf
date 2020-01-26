package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.repos.ReimbursementRepository;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet("/userreimb")
public class UserReimbServlet extends HttpServlet {

    public final ReimbursementRepository reimbRepo = new ReimbursementRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        res.setContentType("application/json");
        try {
            Reimbursement reimb = mapper.readValue(req.getInputStream(), Reimbursement.class);
            Set<Reimbursement> reimbInfo = reimbRepo.findAllById(reimb.getId());
            String reimbInfoJSON = mapper.writeValueAsString(reimbInfo);
            res.getWriter().write(reimbInfoJSON);
            res.setStatus(201);
        } catch (MismatchedInputException e) {
            res.setStatus(400);
        } catch (AuthenticationException e) {
            res.setStatus(401);
        }
        catch (Exception e) {
            res.setStatus(500);
        }


    }

}
