package com.revature.mockERS.servlets;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.repositories.UserRepository;
import com.revature.mockERS.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    private String username, password;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("UserServlet doPost()");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        UserRepository ur = new UserRepository();
        UserService us = new UserService(ur);
        ERS_Users user = us.login(username, password);

    }

}
