package com.revature.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class TestServlet extends HttpServlet {


    @Override
    public void init (ServletConfig config) {
        System.out.println("Test servlet init!");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy invoked");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        System.out.println("Test servlet doGet invoked!");

        //you get a print writer from the response
        PrintWriter writer = res.getWriter();
        writer.write("<h1>Test Works!</h1>");

        res.addHeader("Authorization", "random-value");
        res.setStatus(200);
        res.setContentType("text/html");

    }

}
