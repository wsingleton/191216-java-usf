package com.revature.mockERS.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.mockERS.dto.ErrorResponse;
import com.revature.mockERS.dto.ReimbursementIn;
import com.revature.mockERS.dto.ReimbursementOut;
import com.revature.mockERS.exceptions.ResourcePersistenceException;
import com.revature.mockERS.models.ERS_Reimbursement;
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
        if(UserSession.isAdminOrManager()){
            System.out.println("ReimbursementServlet doPost()");
            resp.setContentType("application/json");
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter writer = resp.getWriter();
            try{
                mapper.writerFor(ReimbursementOut.class);
                List<ReimbursementOut> reimbs = rs.returnAllUnprocessedReimbs();
                StringBuilder reimbursement = new StringBuilder();
                Iterator i = reimbs.iterator();
                while (i.hasNext()) {
                     String reimbJSON = mapper.writeValueAsString(i.next());
                     System.out.println("JSON: "+reimbJSON);
                     reimbursement.append(reimbJSON);
                }
                System.out.println(reimbursement.toString());
                mapper.writeValue(writer, reimbursement.toString());
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
    }
}
