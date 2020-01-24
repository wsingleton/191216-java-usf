package com.revature.mockERS.servlets;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mockERS.dto.ErrorResponse;
import com.revature.mockERS.exceptions.ResourcePersistenceException;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.UserRepository;
import com.revature.mockERS.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService us = new UserService(new UserRepository());

    @Override
    public void init(ServletConfig config){ System.out.println("Servlet initialized!");}

    @Override
    public void destroy(){System.out.println("Destroying!");}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UserServlet doGet()");

        PrintWriter writer = resp.getWriter();
        writer.write("<h1>Hello World!</h1>");
    }

    @Override
    @JsonAnyGetter
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        System.out.println("UserServlet doPut()");
        UserServlet us = new ObjectMapper().readerFor(UserServlet.class).readValue(req.getQueryString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("UserServlet doPost()");
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        try{
            ERS_Users newUser = mapper.readValue(req.getInputStream(), ERS_Users.class);
            us.register(newUser);
            String newUserJSON = mapper.writeValueAsString(newUser);
            writer.write(newUserJSON);
            resp.setStatus(200);
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
}
