package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.dtos.Credentials;
import com.revature.dtos.dto;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import com.revature.models.Reimburstment;
import com.revature.models.Role;
import com.revature.models.Status;
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


@WebServlet("/reimb")
public class ReimbServlet extends HttpServlet {

    public final ReimburstService reimburstService =  new ReimburstService(new ReimburstRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("this-user");
        System.out.println("Arewe here??");
        if(user.getRole() == Role.MANAGER){
            System.out.println("Manager in if statement");
            Set <Reimburstment> reimbs = reimburstService.getAllReim();
            System.out.println(reimbs);
            String reimbsJSON = mapper.writeValueAsString(reimbs);
            resp.getWriter().write(reimbsJSON);
        }else if(user.getRole() == Role.EMPLOYEE){
            System.out.println("Employee");
            Set <Reimburstment> reimbs = reimburstService.getAllReimByAuthor(user.getUser_id());
            String reimbsJSON = mapper.writeValueAsString(reimbs);
            resp.getWriter().write(reimbsJSON);
        } else{
            System.out.println(" none of the above");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try{
            Reimburstment reimb = mapper.readValue(req.getInputStream(), Reimburstment.class);
            reimburstService.createReimb(reimb); // hwy are you not working?
            String reimbJSON = mapper.writeValueAsString(reimb);
            writer.write(reimbJSON);
            HttpSession session = req.getSession();//problem here?
            session.setAttribute("this-reimb", reimb);

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

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json");
        try {
            dto transfer = mapper.readValue(req.getInputStream(), dto.class);
            Reimburstment reimbursement = new Reimburstment();
            reimbursement.setId(transfer.getId());
            reimbursement.setStatus(Status.getStatusbyId(transfer.getStatus()));
            System.out.println(reimbursement);
            reimburstService.update(reimbursement);
        } catch (MismatchedInputException e){
        } catch (ResourceNotFoundException e){
        } catch (Exception e){
        }
    }

}
