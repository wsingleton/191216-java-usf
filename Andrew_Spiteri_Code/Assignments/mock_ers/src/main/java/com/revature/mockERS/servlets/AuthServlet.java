package com.revature.mockERS.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mockERS.dto.Credentials;
import com.revature.mockERS.exceptions.AuthenticationException;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.UserRepository;
import com.revature.mockERS.services.UserService;
import com.revature.mockERS.util.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.MalformedInputException;

import static com.revature.mockERS.util.ConnectionFactory.getCon;


@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    public final UserService us = new UserService(new UserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        ERS_Users authUser = null;
        try{
            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
            authUser = us.login(creds.getUsername(), creds.getPassword());
            String authUserJSON = "{'ersUsername':"+authUser.getErsUsername()+"}";
            UserSession userSession = new UserSession(authUser, getCon());
            writer.write(authUserJSON);
        }catch (MalformedInputException e){
            resp.setStatus(400);
        }catch (AuthenticationException e){
            resp.setStatus(401);
        }catch (Exception e){
            resp.setStatus(500);
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
