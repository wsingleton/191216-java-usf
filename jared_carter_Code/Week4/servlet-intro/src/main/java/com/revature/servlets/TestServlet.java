package com.revature.servlets;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class TestServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config){
        System.out.println("TestServlet.init invoked");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        resp.getWriter().write("<h1>/test works!</h1>");
        // get writer from the response
        PrintWriter writer = resp.getWriter();
        writer.write("<h1> test works !</h1>");
        resp.addHeader("Authorization", "random-value");
        resp.setStatus(200);
        resp.setContentType("test/html");
    }
}