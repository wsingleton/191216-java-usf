package com.revature.demos.web.security;

import com.revature.demos.web.dtos.Principal;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public static String createJwet(Principal subject) {
        SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();

        JwtBuilder builder = Jwts.builder().setId(Integer,)
    }
}
