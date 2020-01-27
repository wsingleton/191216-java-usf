package com.revature.ers.servlets;

import com.revature.ers.utils.RequestViewHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String nextView = RequestViewHelper.process(uri);
        req.getRequestDispatcher(nextView).forward(req, resp);
    }
}
