package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.dtos.Credentials;
import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static com.revature.utils.PageRouter.process;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    public final UserService userService = new UserService(new UserRepository());

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
            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
            //System.out.println("I'm here");
            if(!userService.validate(creds.getUsername()) ||  !userService.validate(creds.getPassword())){
                throw new InvalidRequestException();
            }
            //System.out.println("validated");
            User authUser = userService.authenticate(creds.getUsername(), creds.getPassword());
            String authUserJSON = mapper.writeValueAsString(authUser);
            writer.write(authUserJSON);
            HttpSession session = req.getSession();
            session.setAttribute("this-user", authUser);
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
        }
    }
}