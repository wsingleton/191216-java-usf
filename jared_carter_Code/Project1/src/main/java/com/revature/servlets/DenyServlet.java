package com.revature.ers.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.expections.AuthenticationException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.repos.ReimbursementRepository;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deny")
public class DenyServlet extends HttpServlet {
    public final ReimbursementRepository reimbursementRepository = new ReimbursementRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {
            Reimbursement reimbursement = mapper.readValue(req.getInputStream(), Reimbursement.class);
            reimbursement.setReimbursementStatusId(ReimbursementStatus.DENIED);
            reimbursementRepository.update(reimbursement);
            resp.setStatus(201);
            System.out.println("[LOG] Denied successfully");
        } catch (MismatchedInputException e) {
            resp.setStatus(400);
            System.out.println("[ERR] Error");
        } catch (AuthenticationException e) {
            resp.setStatus(401);
        } catch (Exception e) {
            resp.setStatus(500);
            e.printStackTrace();

        }
    }
}
