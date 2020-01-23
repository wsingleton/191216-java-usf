package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest hsrq, HttpServletResponse hsrp) throws ServletException, IOException{
        hsrp.getWriter().write("<h1>/test works/</h1>");
    }
}
