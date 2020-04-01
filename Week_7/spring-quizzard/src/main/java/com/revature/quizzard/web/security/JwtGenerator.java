package com.revature.quizzard.web.security;

import com.revature.quizzard.web.dtos.Principal;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {

    public static String createJwt(Principal subject) {

        long nowMillis = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder()
                                 .setId(Integer.toString(subject.getId()))
                                 .setSubject(subject.getUsername())
                                 .claim("role", subject.getRole().toString())
                                 .setIssuer("revature")
                                 .setIssuedAt(new Date(nowMillis))
                                 .setExpiration(new Date(nowMillis + JwtConfig.EXPIRATION))
                                 .signWith(JwtConfig.SIG_ALG, JwtConfig.SECRET.getBytes());

        return JwtConfig.PREFIX + builder.compact();

    }
}
