package com.revature.project1.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.project1.dtos.Credentials;
import com.revature.project1.dtos.ErrorResponse;
import com.revature.project1.dtos.RegisterCreds;
import com.revature.project1.exceptions.AuthenticationException;
import com.revature.project1.exceptions.ResourcePersistenceException;
import com.revature.project1.models.Role;
import com.revature.project1.models.User;
import com.revature.project1.repos.UserRepository;
import com.revature.project1.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLIntegrityConstraintViolationException;

import static com.revature.project1.models.Role.EMPLOYEE;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    public UserRepository repo = new UserRepository();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession(false) != null) {
            req.getSession().invalidate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {

            RegisterCreds creds = mapper.readValue(req.getInputStream(), RegisterCreds.class);

            Role role = EMPLOYEE;

            User newUser = new User(creds.getUsername(), creds.getPassword(), creds.getFirstname(), creds.getLastname(),creds.getEmail(),role);
            repo.save(newUser);
            String newUserJSON = mapper.writeValueAsString(newUser);
            writer.write(newUserJSON);

            resp.setStatus(200);


        }
        catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401);
        } catch (ResourcePersistenceException e){
            resp.setStatus(409); // conflict
            ErrorResponse err = new ErrorResponse(409, System.currentTimeMillis());
            err.setMessage(e.getMessage());
            writer.write(mapper.writeValueAsString(err));
        }
        catch (Exception e) {
            resp.setStatus(500);
            e.printStackTrace();
        }




    }

}
