package com.revature.project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.project1.dtos.Credentials;
import com.revature.project1.dtos.IdCreds;
import com.revature.project1.dtos.RegisterCreds;
import com.revature.project1.exceptions.AuthenticationException;
import com.revature.project1.models.Reimbursement;
import com.revature.project1.models.Role;
import com.revature.project1.models.User;
import com.revature.project1.repos.ReimbursementRepository;
import com.revature.project1.repos.UserRepository;
import com.revature.project1.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import static com.revature.project1.models.Role.EMPLOYEE;


@WebServlet("/showERS")
public class ShowERSServlet extends HttpServlet {
    public ReimbursementRepository repo = new ReimbursementRepository();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(false) != null) {
            req.getSession().invalidate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        Set<Reimbursement> reimb = new HashSet<>();

        try {

            IdCreds creds = mapper.readValue(req.getInputStream(), IdCreds.class);
            Role a = Role.valueOf(creds.getRole());
            int id = creds.getId();
            if (a.getId() == 1){
                 reimb =  repo.findAll();
            }
            else {
                reimb =  repo.findAllById(id);
            }


            String reimbJSON = mapper.writeValueAsString(reimb);
            writer.write(reimbJSON);
            resp.setStatus(200);



        }
        catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401);
        } catch (Exception e) {
            resp.setStatus(500);
            e.printStackTrace();
        }
    }

}

