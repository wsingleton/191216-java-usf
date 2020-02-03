package com.ers.liberation.serverlets;

import com.ers.liberation.repos.UserRepository;
import com.ers.liberation.services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/managers/*")
public class ManagerServlet extends HttpServlet {
    private final UserService userService = new UserService(new UserRepository());
}
