package com.revature.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CalculatorServlet.doPost() invoked");
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
        System.out.println(req.getMethod());

        String op1 = req.getParameter("operand1");
        String op2 = req.getParameter("operand2");
        String op = req.getParameter("operator");
        String answer = "";

        try{
            double operand1 = Double.parseDouble(op1);
            double operand2 = Double.parseDouble(op2);

            switch (op){
                case "add":
                    answer = "" + (operand1 + operand2);
                    break;
                    case "subtract":
                    answer = "" + (operand1 - operand2);
                    break;
                case "divide":
                    answer = "" + (operand1 / operand2);
                    break;
                case "multiply":
                    answer = "" + (operand1 * operand2);
                    break;

                default:
                    resp.setStatus(400);
                    throw new RuntimeException("Invalid operator");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        req.setAttribute("answer", answer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("answer");
        dispatcher.forward(req, resp);
        //resp.getWriter().write("the answer is " + answer);
    }
}
