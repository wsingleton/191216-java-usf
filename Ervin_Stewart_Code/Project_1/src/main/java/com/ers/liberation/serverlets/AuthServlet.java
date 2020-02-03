package com.ers.liberation.serverlets;

import com.ers.liberation.dtos.Credentials;
import com.ers.liberation.models.User;
import com.ers.liberation.repos.UserRepository;
import com.ers.liberation.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
    public  class AuthServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(AuthServlet.class);
    public final UserService userService = new UserService(new UserRepository());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        if (req.getSession(false) != null){
            req.getSession().invalidate();
        }
    }

@Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        ObjectMapper mapper = new ObjectMapper();
    PrintWriter writer = resp.getWriter();
    resp.setContentType("application/json");

    try{
        Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
        User authUser = userService.authenticate(creds.getUsername(), creds.getPassword()) ;
        String authUserJSON = mapper.writeValueAsString(authUser);
        writer.write(authUserJSON);
        HttpSession session = req.getSession();
        session.setAttribute("this-user",authUser);

    }catch(MismatchedInputException e){
        LOG.warn(e.getMessage());
        resp.setStatus(400);
    }catch(AuthenticationException e){
        LOG.warn(e.getMessage());
    resp.setStatus(404);
    }catch(Exception e){LOG.warn(e.getMessage()); resp.setStatus(500);}
}


}
