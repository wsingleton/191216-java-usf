package com.revature.ers.servlets;

import com.revature.ers.util.RequestNavHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.nav")
public class NavServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Nav Servlet acting.");
        String nav= RequestNavHelper.process(req.getRequestURI());
        req.getRequestDispatcher(nav).forward(req, resp);
    }
}
