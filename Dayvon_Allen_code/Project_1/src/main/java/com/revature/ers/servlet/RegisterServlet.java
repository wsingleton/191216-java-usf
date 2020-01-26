package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.dtos.Credentials;
import com.revature.ers.dtos.NewUser;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.exceptions.ResourcePersistenceException;
import com.revature.ers.models.Role;
import com.revature.ers.models.User;
import com.revature.ers.repos.UserRepository;
import com.revature.ers.services.UserService;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    public final UserService userService = new UserService(new UserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
//        PrintWriter writer = res.getWriter();
        res.setContentType("application/json");

        try {
            User user = mapper.readValue(req.getInputStream(), User.class);
            userService.register(user);
            res.setStatus(201);
            System.out.println("[LOG] Registered successfully");
        } catch (MismatchedInputException e) {
            res.setStatus(400);
        } catch (AuthenticationException e) {
            res.setStatus(401);
        }
        catch (Exception e) {
            res.setStatus(500);
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (ResourcePersistenceException e) {
            res.setStatus(409);
            e.printStackTrace();
        }
    }
}
