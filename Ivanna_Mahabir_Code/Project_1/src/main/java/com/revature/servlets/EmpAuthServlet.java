package com.revature.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimburstment;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.ReimburstRepository;
import com.revature.services.ReimburstService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/decision")
public class EmpAuthServlet extends HttpServlet {

    public final ReimburstService reimburstService = new ReimburstService(new ReimburstRepository());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("this-user");
        if(user.getRole() == Role.MANAGER){
            Set<Reimburstment> reims = reimburstService.getAllReim();
            String allJSON = mapper.writeValueAsString(reims);
            resp.getWriter().write(allJSON);
        } else{
            Set<Reimburstment> reims = reimburstService.getAllReimByAuthor(user.getUser_id());
            String partialJSON = mapper.writeValueAsString(reims);
            resp.getWriter().write(partialJSON);
        }

    }
}
