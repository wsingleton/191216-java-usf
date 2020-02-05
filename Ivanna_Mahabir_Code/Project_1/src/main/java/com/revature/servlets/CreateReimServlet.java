package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.exceptions.AuthenticationException;
import com.revature.models.Reimburstment;
import com.revature.models.User;
import com.revature.repos.ReimburstRepository;
import com.revature.repos.UserRepository;
import com.revature.services.ReimburstService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/createNew")
public class CreateReimServlet extends HttpServlet {
    public final ReimburstService reimbursementService = new ReimburstService(new ReimburstRepository());
    public final UserRepository userRepository = new UserRepository();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("this-user");
        System.out.println(u);
        System.out.println("1 create");
        try {
            System.out.println("2 create ");
            System.out.println(u.getUser_id());
            Reimburstment reimbursement = mapper.readValue(req.getInputStream(), Reimburstment.class);
            reimbursement.setAuthor(u.getUser_id());
            System.out.println("3 create ");
            System.out.println(reimbursement);
            reimbursementService.createReimb(reimbursement);
            System.out.println("4 create");
            resp.setStatus(201);
        } catch (MismatchedInputException e) {
            resp.setStatus(400);
        } catch (AuthenticationException e) {
            resp.setStatus(401);
        }
        catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(500);
        }
    }
}
