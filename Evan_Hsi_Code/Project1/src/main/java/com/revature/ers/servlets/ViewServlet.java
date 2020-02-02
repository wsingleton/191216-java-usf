package com.revature.ers.servlets;

import com.revature.ers.utils.RequestViewHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewServlet extends HttpServlet {
    private static final Logger LOG = LogManager.getLogger(ViewServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String uri = req.getRequestURI();
        LOG.info("Forwarding to endpoint {}", uri);
        String nextView = RequestViewHelper.process(uri);
        req.getRequestDispatcher(nextView).forward(req, resp);
    }
}
