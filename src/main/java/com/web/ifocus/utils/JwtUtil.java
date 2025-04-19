package com.web.ifocus.utils;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    private String privateKey;
    private String userGenerator;

    public String generateToken(Authentication authentication){
        Algorithm algorithm = Algorithm.HMAC256(privateKey);
        String userName = authentication.getPrincipal().toString();
        String authorities = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
                return JWT.create()
                .withIssuer(this.userGenerator)
                .withSubject(userName)
                .withClaim("authorities" , authorities)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + (30*60000)))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm);
    }

    public DecodedJWT validateToken (String token){
        Algorithm algorithm = Algorithm.HMAC256(privateKey);
        return JWT.require(algorithm)
               .withIssuer(this.userGenerator)
               .build()
               .verify(token);
    }

    public String extractUserName (DecodedJWT decodedJWT){
        return decodedJWT.getSubject();
    }
}
