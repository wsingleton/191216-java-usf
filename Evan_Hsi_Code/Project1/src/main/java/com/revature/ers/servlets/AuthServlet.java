package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.Credentials;
import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthServlet extends HttpServlet {
    private final UserService userService = new UserService(new UserRepository());
    private static final Logger LOG = LogManager.getLogger(AuthServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {

            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
            System.out.println(creds.getUsername());
            System.out.println(creds.getPassword());
            User authUser = userService.authenticate(creds.getUsername(), creds.getPassword());

            LOG.info("Attempting to validate user credentials");

            if(authUser.getRole().equals(Role.LOCKED)) {

                LOG.info("Attempted login by user with role UNCONFIRMED");

                throw new InvalidRequestException();
            }
            else {
                String authUserJSON = mapper.writeValueAsString(authUser);
                writer.write(authUserJSON);
                authUser.setPassword("**********");
                HttpSession session = req.getSession();
                session.setAttribute("this-user", authUser);
                LOG.info("Establishing session for user {}", authUser.getUsername());
            }

        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(401);
        } catch (InvalidRequestException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(402);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(500);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession(false) != null) {
            req.getSession().invalidate();
            LOG.info("Invalidating user session");
        }
    }
}
