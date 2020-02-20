package com.revature.quizzard.web.security;

import com.revature.quizzard.web.dtos.Principal;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {

    public static String createJwt(Principal subject) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        JwtBuilder builder = Jwts.builder()
                .setId(Integer.toString(subject.getId()))
                .setSubject(subject.getUsername())
                .claim("role", subject.getRole().toString())
                .setIssuer("revature")
                .setIssuedAt(new Date(nowMillis))
                .setExpiration(new Date(nowMillis + JwtConfig.EXPIRATION))
                .signWith(signatureAlgorithm,JwtConfig.SECRET.getBytes());

        return JwtConfig.PREFIX + builder.compact();
    }
}
