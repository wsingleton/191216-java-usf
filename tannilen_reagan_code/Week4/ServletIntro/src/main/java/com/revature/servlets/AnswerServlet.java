package com.revature.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ans=(String)req.getAttribute("answer");
        resp.getWriter().write("<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\"/></head><body><div class=\"content\"><h1>Your answer is: </h1><h2>" + ans + "</h2>");
        resp.getWriter().write("<br/><a href=\"index.html\">Calcluate something else?</a></body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
