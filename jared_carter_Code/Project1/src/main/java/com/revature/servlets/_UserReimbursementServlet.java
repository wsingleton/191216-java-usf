package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.models.Reimbursement;
import com.revature.repos.ReimbursementRepository;


import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


@WebServlet("/userreimb")
public class _UserReimbursementServlet extends HttpServlet {

    public final ReimbursementRepository reimbursementRepository = new ReimbursementRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        try {
            Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
            Set<Reimbursement> reimbursementInfo = reimbursementRepository.findAllById(reimbursement.getId());
            String reimbursementInfoJSON = mapper.writeValueAsString(reimbursementInfo);
            resp.getWriter().write(reimbursementInfoJSON);
            resp.setStatus(201);
        } catch (MismatchedInputException e) {
            resp.setStatus(400);

        } catch (AuthenticationException e) {
            resp.setStatus(401);

        }
        catch (Exception e) {
            resp.setStatus(500);

        }


    }

}
