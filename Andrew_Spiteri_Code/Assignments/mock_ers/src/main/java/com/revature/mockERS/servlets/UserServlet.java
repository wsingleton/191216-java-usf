package com.revature.mockERS.servlets;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private String username, password;

    @JsonCreator
    public UserServlet(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password
    ){
        this.username = username;
        this.password = password;
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<h1>Hello World!</h1>");
    }

    @Override
    @JsonAnyGetter
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        UserServlet us = new ObjectMapper().readerFor(UserServlet.class).readValue(req.getQueryString());
    }
}
