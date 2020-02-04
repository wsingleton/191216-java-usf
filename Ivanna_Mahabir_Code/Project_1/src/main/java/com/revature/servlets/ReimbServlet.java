package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.dtos.Credentials;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.Reimburstment;
import com.revature.models.User;
import com.revature.repos.ReimburstRepository;
import com.revature.services.ReimburstService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import static com.revature.utils.PageRouter.process;

@WebServlet("/dashboard")
public class ReimbServlet extends HttpServlet {

    public final ReimburstService reimburstService =  new ReimburstService(new ReimburstRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        String userIdParam = req.getParameter("reimb_author");

        if(req.getSession(false) != null){
            req.getSession().invalidate();
        }
        else{
            try{
                Set<Reimburstment> reimb = reimburstService.getAllReimByAuthor(Integer.parseInt(userIdParam));
                String reimbJSON = mapper.writeValueAsString(reimb);
                resp.getWriter().write(reimbJSON);
            }catch(Exception e){
                resp.setStatus(400);
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try{
            Reimburstment reimb = new Reimburstment();
            reimb = mapper.readValue(req.getInputStream(), Reimburstment.class);
            System.out.println("I'm here");
            reimburstService.createReimb(reimb);
            System.out.println("creation");
            String reimbJSON = mapper.writeValueAsString(reimb);
            writer.write(reimbJSON);
            HttpSession session = req.getSession();
            session.setAttribute("this-reimb", reimb);
            process("/reimb.view");

        }
        catch (MismatchedInputException e){
            resp.setStatus(400);
        }
        catch (AuthenticationException e){
            resp.setStatus(401);
        }
        catch (Exception e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }

}
