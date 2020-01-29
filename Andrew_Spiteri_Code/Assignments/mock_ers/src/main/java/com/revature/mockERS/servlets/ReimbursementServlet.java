package com.revature.mockERS.servlets;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.mockERS.dto.ErrorResponse;
import com.revature.mockERS.dto.ReimbursementIn;
import com.revature.mockERS.dto.ReimbursementOut;
import com.revature.mockERS.exceptions.ResourceNotFoundException;
import com.revature.mockERS.exceptions.ResourcePersistenceException;
import com.revature.mockERS.models.ERS_Reimbursement;
import com.revature.mockERS.models.ERS_User_Roles;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.ReimbursementRepository;
import com.revature.mockERS.services.ReimbursementService;
import com.revature.mockERS.util.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@WebServlet("/reimb")
public class ReimbursementServlet extends HttpServlet {
    ReimbursementService rs = new ReimbursementService(new ReimbursementRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ReimbursementServlet doPost()");
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        try{
            ReimbursementIn newReimb = mapper.readValue(req.getInputStream(), ReimbursementIn.class);
            Boolean created = rs.createNew(newReimb);
            String newReimbJSON = mapper.writeValueAsString(newReimb);
            writer.write(newReimbJSON);
            if(created) {
                resp.setStatus(201);
            }else{
                throw new ResourcePersistenceException();
            }
        }catch (MismatchedInputException e){
            resp.setStatus(400);
            writer.write(e.getMessage());
        }catch (ResourcePersistenceException e){
            resp.setStatus(409);
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        }catch (Exception e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ERS_Users authUser = (ERS_Users) req.getSession(false).getAttribute("this-user");

        if(authUser.getRole().equals(ERS_User_Roles.FINANCE_MANAGER)){
            System.out.println("Finance ReimbursementServlet doPost()");
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter writer = resp.getWriter();
            try{
                List<ReimbursementOut> reimbs = rs.returnAllUnprocessedReimbs();
                mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                writer.print(mapper.writeValueAsString(reimbs));
            }catch (ResourceNotFoundException e){
                resp.setStatus(409);
                ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
                err.setMessage(e.getMessage());
                writer.write(mapper.writeValueAsString(err));
            }catch (Exception e){
                resp.setStatus(500);
                e.printStackTrace();
            }
        }//TODO Create else statement that returns ReimbursementOut objects to Basic Users
        else{
            System.out.println("Finance ReimbursementServlet doPost()");
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter writer = resp.getWriter();
            try{
                Set<ReimbursementOut> reimbs = rs.returnReimbursementByUser(authUser.getId());
                mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
                writer.print(mapper.writeValueAsString(reimbs));
                System.out.println("Basic Reimbs: " + reimbs);
            }catch (ResourceNotFoundException e){
                resp.setStatus(409);
                ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
                err.setMessage(e.getMessage());
                writer.write(mapper.writeValueAsString(err));
            }catch (Exception e){
                resp.setStatus(500);
                e.printStackTrace();
            }

        }
    }

    //todo finish method
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ERS_Users authUser = (ERS_Users) req.getSession(false).getAttribute("this-user");

        if(authUser.getRole().equals(ERS_User_Roles.FINANCE_MANAGER)){
            System.out.println("Finance ReimbursementServlet doPut()");
            resp.setContentType("application/json");
            ObjectMapper inmapper = new ObjectMapper();
            PrintWriter writer = resp.getWriter();
            try{
                ReimbursementIn updateReimb = inmapper.readValue(req.getInputStream(), ReimbursementIn.class);
                Boolean created = rs.updateStatus(updateReimb);
                String newReimbJSON = inmapper.writeValueAsString(updateReimb);
                writer.write(newReimbJSON);
                if(created) {
                    resp.setStatus(201);
                }else{
                    throw new ResourcePersistenceException();
                }
            }catch (MismatchedInputException e){
                resp.setStatus(400);
                writer.write(e.getMessage());
            }catch (ResourcePersistenceException e){
                resp.setStatus(409);
                ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
                err.setMessage(e.getMessage());
                writer.write(inmapper.writeValueAsString(err));
            }catch (Exception e){
                resp.setStatus(500);
                e.printStackTrace();
            }
        }
    }
}
