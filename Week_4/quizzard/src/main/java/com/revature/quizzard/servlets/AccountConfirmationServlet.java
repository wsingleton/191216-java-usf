package com.revature.quizzard.servlets;

import com.revature.quizzard.dtos.HttpStatus;
import com.revature.quizzard.exceptions.InvalidRequestException;
import com.revature.quizzard.exceptions.ResourceNotFoundException;
import com.revature.quizzard.services.UserService;
import com.revature.quizzard.util.ApplicationProperties;
import com.revature.quizzard.util.ErrorResponseFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.revature.quizzard.util.ApplicationProperties.APP_URL;

@WebServlet("/confirmation")
public class AccountConfirmationServlet extends HttpServlet {

    private static final Logger LOG = LogManager.getLogger(UserServlet.class);

    private final UserService USER_SERVICE = UserService.getInstance();
    private final ErrorResponseFactory errRespFactory = ErrorResponseFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String userIdParam = req.getParameter("userId");
        resp.setContentType("text/html");

        try {

            if (userIdParam != null) {
                int userId = Integer.parseInt(userIdParam);
                LOG.info("Attempting to confirm account with id, {}", userId);
                USER_SERVICE.confirmAccount(userId);
                LOG.info("Account belonging to user with id, {}, successfully confirmed.");
                resp.sendRedirect(APP_URL);
            } else {
                throw new InvalidRequestException();
            }

        } catch (NumberFormatException | InvalidRequestException e) {
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
}
