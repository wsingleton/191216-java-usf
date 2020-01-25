package com.revature.ers.servlet;

import com.revature.ers.util.RequestViewHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(req.getRequestURI());
        String nextView = RequestViewHelper.process(req.getRequestURI());
        req.getRequestDispatcher(nextView).forward(req, res);
    }
}