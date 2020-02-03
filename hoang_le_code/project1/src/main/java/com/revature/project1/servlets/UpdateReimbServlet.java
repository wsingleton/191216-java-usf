package com.revature.project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.project1.dtos.ErrorResponse;
import com.revature.project1.dtos.RegisterCreds;
import com.revature.project1.dtos.ReimbCreds;
import com.revature.project1.exceptions.AuthenticationException;
import com.revature.project1.exceptions.ResourcePersistenceException;
import com.revature.project1.models.*;
import com.revature.project1.repos.ReimbursementRepository;
import com.revature.project1.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.revature.project1.models.Role.EMPLOYEE;

@WebServlet("/updateReimb")
public class UpdateReimbServlet extends HttpServlet {
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

        try {

            ReimbCreds creds = mapper.readValue(req.getInputStream(), ReimbCreds.class);

            Status status = Status.getById(creds.getStatusID());
            Type type =Type.getById(creds.getTypeId());

            Reimbursement reimb = new Reimbursement(creds.getAuthId(),creds.getAmount(),creds.getSubTime(),creds.getResTime(),creds.getDesc(),
                    creds.getReceipt(),creds.getAuthId(),creds.getResolver(),status,type);
            if(creds.getAuthId() == 0){
                resp.setStatus(400);

            }else {
                repo.update(reimb);
                String newUserJSON = mapper.writeValueAsString(reimb);
                writer.write(newUserJSON);
                resp.setStatus(201);
            }



        }
        catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401);
        } catch (ResourcePersistenceException e){
            resp.setStatus(409); // conflict
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        }
        catch (Exception e) {
            resp.setStatus(500);
            e.printStackTrace();
        }




    }
}
