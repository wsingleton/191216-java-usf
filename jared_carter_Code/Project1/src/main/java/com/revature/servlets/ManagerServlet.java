package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {



    static ReimbursementService rServ = new ReimbursementService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Set<Reimbursement> reim = rServ.getAllReimbursements();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reim);

        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        writer.write(json);

    }


}
