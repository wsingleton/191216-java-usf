package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourceNotFoundException;
import com.revature.ers.exceptions.ResourcePersistenceException;
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
import java.util.Set;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService(new UserRepository());
    private static final Logger LOG = LogManager.getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        String userIdParam = req.getParameter("userId");
        resp.setContentType("application/JSON");

        if (req.getSession(false) != null) {
            User thisUser = (User) req.getSession().getAttribute("this-user");

        }

        if (userIdParam == null) {
            Set<User> users = userService.getAllUsers();
            String usersJSON = mapper.writeValueAsString(users);
            resp.getWriter().write(usersJSON);

        }else {
            try{
                User user = userService.getUserById(Integer.parseInt(userIdParam));
                String userJSON = mapper.writeValueAsString(user);
                resp.getWriter().write(userJSON);
            }catch (Exception e){
                resp.setStatus(400);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();

        try {

            User newUser = mapper.readValue(req.getInputStream(), User.class);
            LOG.info("Attempting to register a new user.");
            User authUser = userService.register(newUser);
            String newUserJSON = mapper.writeValueAsString(newUser);

            resp.setStatus(201); // created
            LOG.info("New user, {}, created.", authUser.getUsername());
            HttpSession session = req.getSession();
            session.setAttribute("this-user", authUser);

        }catch (MismatchedInputException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(400); // bad request
        } catch(ResourceNotFoundException e) {
            LOG.warn(e.getMessage());
            resp.setStatus(409); // conflict
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        } catch (ResourcePersistenceException e) {
            LOG.error(e.getMessage());
            resp.setStatus(401);
        } catch(Exception e) {  
            LOG.error(e.getMessage());
            resp.setStatus(500); // internal server error
        }

    }
}
