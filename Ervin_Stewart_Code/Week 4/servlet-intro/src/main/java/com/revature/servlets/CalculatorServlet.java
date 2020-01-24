package com.revature.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        System.out.println("CalculatorServlet.doPost() invoked!");
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>/test works!</h1>");

        resp.addHeader("Authorization", "random-value");
        resp.setStatus(200);
        resp.setContentType("text/html");
    }

    @Override
    public void init(ServletConfig config){
        System.out.println("TestServlet.init() invoked!");
    }

}
