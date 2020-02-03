package com.revature.reimbursement_app.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.reimbursement_app.exceptions.AuthenticationException;
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
import java.io.IOException;
import java.util.Set;

@WebServlet("/usreimb")
public class UserReimbServlet extends HttpServlet {

    private final ReimbursementService reimbService = new ReimbursementService(new ReimbursementRepo());
    private static final Logger LOG = LogManager.getLogger(UserReimbServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try{
            LOG.info("Gets all reimbursements created by current user");
            User user = mapper.readValue(req.getInputStream(), User.class);
            Set<Reimbursement> reimbursements = reimbService.getReimbursementsByUserId(user.getId());
            String reimbursementsJSON = mapper.writeValueAsString(reimbursements);
            resp.getWriter().write(reimbursementsJSON);
            resp.setStatus(201);
        } catch (MismatchedInputException e){
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        } catch (AuthenticationException e){
            LOG.warn(e.getMessage());
            resp.setStatus(401);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(500);
        }

    }

}
