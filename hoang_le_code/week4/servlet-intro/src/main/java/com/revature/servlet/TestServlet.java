package com.revature.servlet;

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
        System.out.println("testServlet.init() servlet");
    }

    @Override
    public void destroy(){
        System.out.println("testServlet.destroy invoked");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("testServlet.destroy invoked");

        PrintWriter writer = resp.getWriter();
        writer.write("<h1>/test works!</h1>");

        resp.addHeader("authorization","random-value");
        resp.setStatus(200);
        resp.setContentType("text/html");


    }
}
