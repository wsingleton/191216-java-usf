package com.revature.reimbursement_app.servlets;

import com.revature.reimbursement_app.util.RequestViewHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.view")
public class ViewServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(ViewServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOG.info("Changes webpage view");
        String nextView = RequestViewHelper.process(req.getRequestURI());
        req.getRequestDispatcher(nextView).forward(req,resp);

    }

}
