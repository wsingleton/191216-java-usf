package com.revature.ers.servlets;

import com.revature.ers.util.RequestViewHelper;
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
        LOG.info("Request received to view new page.");
        String nextView = RequestViewHelper.process(req.getRequestURI());


        LOG.info("URI request valid. Forwarding to, {} ", nextView);
        req.getRequestDispatcher(nextView).forward(req, resp);

    }

}
