package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        writer.write("<p>Test Successful</p>");
        //req.getRequestDispatcher("index.html").forward(req, resp);
        resp.sendRedirect("index.html");

    }
}
