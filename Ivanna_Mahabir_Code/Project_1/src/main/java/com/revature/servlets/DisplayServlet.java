package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.models.Reimburstment;
import com.revature.repos.ReimburstRepository;
import com.revature.services.ReimburstService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

    public final ReimburstService reimburstService = new ReimburstService(new ReimburstRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession(false) != null){
            req.getSession().invalidate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try{
            Reimburstment reimbs = mapper.readValue(req.getInputStream(), Reimburstment.class);
            reimburstService.getAllReimByAuthor(reimbs.getAuthor());
            String reimbsJSON = mapper.writeValueAsString(reimbs);
            writer.write(reimbsJSON);
            resp.setStatus(201);
        }catch(Exception e){
            resp.setStatus(500);
        }
    }
}
