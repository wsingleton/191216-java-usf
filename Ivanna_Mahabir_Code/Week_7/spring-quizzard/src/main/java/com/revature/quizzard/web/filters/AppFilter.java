package com.revature.quizzard.web.filters;

import com.revature.quizzard.entities.UserRole;
import com.revature.quizzard.web.dtos.Principal;
import com.revature.quizzard.web.security.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter("/*")
public class AppFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        applyCorsHeaders(resp);
        chain.doFilter(req, resp);
    }

    private void applyCorsHeaders(HttpServletResponse resp) throws IOException, ServletException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Expose-Headers", "Authorization");
    }

    private void parseToken(HttpServletRequest req){

        String header = req.getHeader(JwtConfig.HEADER);

        if(header == null || !header.startsWith(JwtConfig.PREFIX)){
            return;
        }

        String token = header.replaceAll(JwtConfig.PREFIX, "");

        Claims claims = Jwts.parser()
                            .setSigningKey(JwtConfig.SECRET.getBytes())
                            .parseClaimsJws(token)
                            .getBody();

        int id  = Integer.parseInt(claims.getId());
        String username = claims.getSubject();
        UserRole role = claims.get("role", UserRole.class);
        Principal principal = new Principal(id, username, role);
        req.setAttribute("principal", principal);
    }
}
