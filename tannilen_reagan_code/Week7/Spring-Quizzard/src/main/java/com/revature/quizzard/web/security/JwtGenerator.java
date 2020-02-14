package com.revature.quizzard.web.security;

import com.revature.quizzard.web.dtos.Principal;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {
    public static String createJWT(Principal subj) {
        SignatureAlgorithm sigAl=SignatureAlgorithm.HS256;
        long now=System.currentTimeMillis();
        JwtBuilder builder= Jwts.builder()
                .setId(Integer.toString(subj.getId()))
                .setSubject(subj.getUsername())
                .claim("role", subj.getRole().toString())
                .setIssuer("Revature")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now+JwtConfig.EXPIRATION))
                .signWith(sigAl,JwtConfig.SECRET.getBytes());
        return JwtConfig.PREFIX+builder.compact();
    }
}
