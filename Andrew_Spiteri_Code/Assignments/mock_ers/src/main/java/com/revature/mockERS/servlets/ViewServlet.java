package com.revature.mockERS.servlets;

import com.revature.mockERS.models.ERS_Users;
import com.revature.mockERS.util.RequestViewHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("*.view")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MADE IT INTO ViewServlet.doGet!!!");
        String nextView = RequestViewHelper.process(req);
        req.getRequestDispatcher(nextView).forward(req, resp);
    }
}
