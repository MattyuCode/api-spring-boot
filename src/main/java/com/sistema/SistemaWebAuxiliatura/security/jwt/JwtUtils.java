package com.sistema.SistemaWebAuxiliatura.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {
    @Value("${jwt.secretKey}")
    private String secretKey;
    @Value("${jwt.time.expiration}")
    private String timeExpiration;

    //METODO PARA CREAR TOKEN
    public String GenerateAccessToken(String userName) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                .signWith(getSignareKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //VALIDAR TOKEN DE ACCESO
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getSignareKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            return true;
        } catch (Exception e) {
            log.error(("Token invalid, error: ".concat(e.getMessage())));
            return false;
        }
    }

    //OBTENER EL USERNAME DEL TOKEN
    public String getUserNameFromToken(String token) {
        return getClaims(token, Claims::getSubject);
    }


    //OBTENER UN SOLO CLAIMS
    public <T> T getClaims(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }


    //OBTENER TODOS LOS CLAIMS DEL TOKEN
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignareKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //Obtener firma del token
    public Key getSignareKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
