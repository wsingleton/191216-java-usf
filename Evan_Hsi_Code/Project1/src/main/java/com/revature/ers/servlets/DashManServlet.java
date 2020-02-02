package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.Reimbursement;
import com.revature.ers.models.User;
import com.revature.ers.repositories.ReimbursementRepository;
import com.revature.ers.services.ReimbursementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

public class DashManServlet extends HttpServlet {
    private final ReimbursementService rServ = new ReimbursementService(new ReimbursementRepository());
    private static final Logger LOG = LogManager.getLogger(DashManServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        try {

            HttpSession session = req.getSession(false);
            LOG.info("Retrieving user from session");
            User user = (User) session.getAttribute("this-user");
            System.out.println(user.getRole());
            LOG.info("Retrieving all reimbursements for user {}", user.getUsername());
            Set<Reimbursement> reimbs = rServ.getByAuthorId(user.getId(), user);
            String reimbJSON = mapper.writeValueAsString(reimbs);
            writer.write(reimbJSON);

        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        }
    }
}
