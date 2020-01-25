package com.revature.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

//introduced in servlet api v3
@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        String answer = (String) req.getAttribute("answer");
        pw.write("<p>answer is " + answer + "</p>" );
        pw.write("<br><a href=\"index.html\">Calculate something else </a>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       doGet(req,res);
    }
}
