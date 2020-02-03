package com.ers.liberation.serverlets;

import com.ers.liberation.dtos.AdminAccess;
import com.ers.liberation.dtos.ErrorResponse;
import com.ers.liberation.exceptions.AuthenticationException;
import com.ers.liberation.exceptions.AuthorizationException;
import com.ers.liberation.exceptions.ResourcePersistenceException;
import com.ers.liberation.models.User;
import com.ers.liberation.repos.UserRepository;
import com.ers.liberation.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
private final UserService userService = new UserService(new UserRepository());

@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    String userIdParam = req.getParameter("userId");
    resp.setContentType("application/json");
    ObjectMapper mapper = new ObjectMapper();

        if(req.getSession(false) != null){
            User thisUser = (User) req.getSession().getAttribute("this-user");
            System.out.println(thisUser);

        }
    if(userIdParam == null){
        Set<User> users = userService.getAllUsers();
        String userJSON = mapper.writeValueAsString(users);
        resp.getWriter().write(userJSON);

    }else{
        try{User user = userService.getUserById(Integer.parseInt(userIdParam));
        String userJSON = mapper.writeValueAsString(user);
        resp.getWriter().write(userJSON);
        }catch(Exception e){resp.setStatus(400);}
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    ObjectMapper mapper = new ObjectMapper();
    PrintWriter writer = resp.getWriter();

    resp.setContentType("application/json");

    try{ User newUser = mapper.readValue(req.getInputStream(), User.class);
        userService.register(newUser);
        String newUserJSON = mapper.writeValueAsString(newUser);
        writer.write(newUserJSON);
        HttpSession session = req.getSession();
        session.setAttribute("this-user",newUser);
        resp.setStatus(201);
    }catch(MismatchedInputException e){resp.setStatus(400);}
    catch(ResourcePersistenceException e){resp.setStatus(409);
        ErrorResponse err = new ErrorResponse(409,System.currentTimeMillis());
        err.setMessage(e.getMessage());
    writer.write(mapper.writeValueAsString(err));
    }catch(Exception e){ resp.setStatus(500);}
}
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        resp.setContentType("application/json");

        try{
            AdminAccess accessCode = mapper.readValue(req.getInputStream(), AdminAccess.class);
        if(userService.adminValidation(accessCode.getAccessCode()) == 2){

        }else if(userService.adminValidation(accessCode.getAccessCode()) == 3){

        }else
        resp.setStatus(200);
    }catch(MismatchedInputException e){
    resp.setStatus(400);
    }catch(AuthorizationException e){
    resp.setStatus(401);
    ErrorResponse err= new ErrorResponse(401,System.currentTimeMillis());
    err.setMessage(err.getMessage());
    }catch(Exception e){resp.setStatus(500);}

    }

}
