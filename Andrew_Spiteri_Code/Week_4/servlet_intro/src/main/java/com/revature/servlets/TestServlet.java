package com.revature.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest hsrq, HttpServletResponse hsrp) throws ServletException, IOException{
        System.out.println("TestServlet.doGet() invoked!");

        PrintWriter writer = hsrp.getWriter();
        writer.write("<h1>Test works!</h1>");

        hsrp.addHeader("Authorization", "random-value");
        hsrp.setStatus(200);
        hsrp.setContentType("text/html");
    }

    @Override
    public void init(ServletConfig config){
        System.out.println("TestServlet.init() invoked");
    }

    @Override
    public void destroy(){
        System.out.println("destroy() called");
    }
}
