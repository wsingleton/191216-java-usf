package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.Credentials;
import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    private final UserService userService = new UserService(new UserRepository());
    private static final Logger LOG = LogManager.getLogger(AuthServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session != null) {
            String username = ((User) session.getAttribute("this-user")).getUsername();
            LOG.info("Invalidating session for user, {}", username);
            req.getSession().invalidate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/JSON");

        try {

            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);

            LOG.info("Attempting to authenticate user, {}, with provided credentials", creds.getUsername());
            User authUser = userService.authenticate(creds.getUsername(), creds.getPassword());


            writer.write(mapper.writeValueAsString(authUser));

            LOG.info("Establishing a session for user, {}", creds.getUsername());
            req.getSession().setAttribute("this-user", authUser);

        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
            // create Error response factory
        }catch (AuthenticationException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(401);
        }catch (Exception e) {
            LOG.error(e.getMessage());
            resp.setStatus(500);
            e.printStackTrace();
        }

    }
}
