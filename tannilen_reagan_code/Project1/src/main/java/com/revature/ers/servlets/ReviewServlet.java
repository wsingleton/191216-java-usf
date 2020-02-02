package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dto.Approvals;
import com.revature.ers.dto.Credentials;
import com.revature.ers.models.Reimbursement;
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
import java.util.HashSet;
import java.util.Set;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    public final ReimbursementService reimbService=new ReimbursementService(new ReimbursementRepository());
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Review decision received.");
        User u=(User) req.getSession().getAttribute("this-user");
        ObjectMapper mapper = new ObjectMapper();
        Approvals approval=mapper.readValue(req.getInputStream(), Approvals.class);
        System.out.println("Reimbursement "+approval.getReimbID()+" approved: "+approval.isApproved());
        boolean successful=reimbService.updateReimb(approval.getReimbID(),approval.isApproved(),u.getUserID());
        if (successful==true) {
            System.out.println("Reimbursement update successful.  Notifying UI.");
            resp.setStatus(200);
        }
        else if (successful==false) {
            System.out.println("Reimbursement update failed. Notifying UI.");
            resp.setStatus(400);
        }
    }
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u=(User) req.getSession().getAttribute("this-user");
        System.out.println(u.getUsername()+" has posted a request to Review Servlet.");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        Set<Reimbursement> reimbs=new HashSet<>();
        if (u.getRole()==1) {
            System.out.println("Mgr user identified.  Calling all reimbursements.");
            reimbs=reimbService.viewAll();
        }
        if (u.getRole()==2) {
            System.out.println("Non-manager user identified.  Calling reimbursements for user ID " + u.getUserID());
            reimbs=reimbService.viewSubmitted(u.getUserID());
        }
        String reimbsJSON=mapper.writeValueAsString(reimbs);
        writer.write(reimbsJSON);
    }
}
