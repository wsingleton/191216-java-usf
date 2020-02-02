package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;
import com.revature.models.UserRole;
import com.revature.repos.ReimbursementRepository;
import com.revature.repos.UserRepository;
import com.revature.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebServlet("/getreimbbystatus")
public class GetReimbByStatusServlet extends HttpServlet {
    public final ReimbursementService reimbursementService = new ReimbursementService(new ReimbursementRepository());
    public final UserRepository userRepository = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("this-user");
        System.out.println(user.getUserRole());
        if (user.getUserRole() == UserRole.MANAGER){
            Set<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
            String reimbursementsJSON = mapper.writeValueAsString(reimbursements);
            resp.getWriter().write(reimbursementsJSON);
        } else {
            try {
                Set<Reimbursement> reimbursements = reimbursementService.getByAuthorId(user.getId());
                String reimbursementsJSON = mapper.writeValueAsString(reimbursements);
                resp.getWriter().write(reimbursementsJSON);
            }catch (Exception e){
                resp.setStatus(400);
            }
        }
    }


}