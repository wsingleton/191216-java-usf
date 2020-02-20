package com.revature.demos.web.filters;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//every method that comes to it should have these things done to it, this class is to help solve the CORS issue

@Component
@WebFilter("/*")
public class AppFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {

        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-type");
        resp.setHeader("Access-Control-Expose-Headers", "Authorization");
        chain.doFilter(req, resp);
    }
}
