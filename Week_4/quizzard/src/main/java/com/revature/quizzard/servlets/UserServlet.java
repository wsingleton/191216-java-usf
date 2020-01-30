package com.revature.quizzard.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.quizzard.dtos.HttpStatus;
import com.revature.quizzard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.exceptions.ResourcePersistenceException;
import com.revature.quizzard.models.User;
import com.revature.quizzard.services.MailService;
import com.revature.quizzard.services.UserService;
import com.revature.quizzard.util.ErrorResponseFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final MailService mailService = MailService.getInstance();
    private final ErrorResponseFactory errRespFactory = ErrorResponseFactory.getInstance();
    private static final Logger LOG = LogManager.getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = req.getSession(false);
        User rqstr = (session == null) ? null : (User) req.getSession(false).getAttribute("this-user");
        resp.setContentType("application/json");

        String userIdParam = req.getParameter("userId");


        try {

            if (rqstr != null && rqstr.isAdminOrDev()) {

                LOG.info("UserServlet.doGet() invoked by requester {}", rqstr);

                if (userIdParam == null) {
                    LOG.info("Retrieving all users");
                    Set<User> users = userService.getAllUsers();
                    String usersJSON = mapper.writeValueAsString(users);
                    writer.write(usersJSON);
                } else {
                    int soughtId = Integer.parseInt(userIdParam);
                    LOG.info("Retrieving users with id, {}" , soughtId);
                    User user = userService.getUserById(soughtId);
                    String userJSON = mapper.writeValueAsString(user);
                    writer.write(userJSON);
                }

            } else {

                if (rqstr == null) {
                    LOG.warn("Unauthorized request made by unknown requester");
                    resp.setStatus(401);
                    writer.write(errRespFactory.generateErrorResponse(HttpStatus.UNAUTHORIZED).toJSON());
                } else {
                    LOG.warn("Request made by requester, {}, who lacks proper authorities", rqstr.getUsername());
                    resp.setStatus(403);
                    writer.write(errRespFactory.generateErrorResponse(HttpStatus.FORBIDDEN).toJSON());
                }

            }

        } catch (NumberFormatException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.BAD_REQUEST).toJSON());
        } catch (ResourceNotFoundException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(404);
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.NOT_FOUND).toJSON());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            resp.setStatus(500);
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR).toJSON());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");

        try {

            User newUser = mapper.readValue(req.getInputStream(), User.class);
            userService.register(newUser);
            String newUserJSON = mapper.writeValueAsString(newUser);
            writer.write(newUserJSON);
            resp.setStatus(201); // created
            mailService.sendAccountConfirmationEmail(newUser);

        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400); // bad request
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.BAD_REQUEST).toJSON());
        } catch (ResourcePersistenceException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(409); // conflict
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.CONFLICT).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error(e.getMessage());
            resp.setStatus(500); // internal server error
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR).toJSON());
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession(false);
        User rqstr = (session == null) ? null : (User) req.getSession(false).getAttribute("this-user");
        resp.setContentType("application/json");

        try {

            User updatedUser = mapper.readValue(req.getInputStream(), User.class);

            if (rqstr != null) {

                if (rqstr.getId() == updatedUser.getId()) {
                    LOG.info("Request made by requester, {}, to update their own info", rqstr);
                    userService.updateProfile(updatedUser);
                    session.setAttribute("this-user", updatedUser);
                } else if (rqstr.getId() != updatedUser.getId() && rqstr.isAdminOrDev()) {
                    LOG.info("Request made by requester, {}, to update the info of user with username, {}", rqstr, updatedUser.getUsername());
                    userService.updateProfile(updatedUser);
                } else {
                    LOG.warn("Request made by requester, {}, who lacks proper authorities", rqstr.getUsername());
                    resp.setStatus(403);
                    writer.write(errRespFactory.generateErrorResponse(HttpStatus.FORBIDDEN).toJSON());
                }

            } else {
                LOG.warn("Unauthorized request made by unknown requester");
                resp.setStatus(401);
                writer.write(errRespFactory.generateErrorResponse(HttpStatus.UNAUTHORIZED).toJSON());
            }

        } catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400);
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.BAD_REQUEST).toJSON());
        } catch (ResourcePersistenceException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(409);
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.CONFLICT).toJSON());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            resp.setStatus(500);
            writer.write(errRespFactory.generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR).toJSON());
        }

    }
}
