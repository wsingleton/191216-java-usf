package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.email.MKEmailSessionBean;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.User;
import com.revature.ers.repositories.UserRepository;
import com.revature.ers.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    private final UserService userService = new UserService(new UserRepository());
    @EJB
    private MKEmailSessionBean MKBean = new MKEmailSessionBean();
    private static final Logger LOG = LogManager.getLogger(RegisterServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {
            User user = mapper.readValue(req.getInputStream(), User.class);
            LOG.info("Registering User");
            userService.register(user, new User());
            String authUserJSON = mapper.writeValueAsString(user);
            writer.write(authUserJSON);
            HttpSession session = req.getSession();

            session.setAttribute("this-user", user);
            LOG.info("Sending confirmation email to address {}", user.getEmail());
            String to = user.getEmail();
            String subject = "Confirmation";
            String body = "localhost:8080/project1/confirmation?user_id=" + user.getId();
            MKBean.sendEmail(to, subject, body);
            resp.setStatus(201);

        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
        } catch (ResourcePersistenceException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(401);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
            resp.setStatus(500);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
