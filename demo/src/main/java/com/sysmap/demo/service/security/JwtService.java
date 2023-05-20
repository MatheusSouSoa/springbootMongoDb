package com.sysmap.demo.service.security;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService implements IJwtService {
    
    private final long EXPIRATION_TIME = 7200000;
    private final String KEY = "68566D597133743677397A24432646294A404E635266546A576E5A7234753778";

    public String generateToken(UUID userId){
        return Jwts
                .builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(
                        genSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isValidtoken(String token, String userId){
        var claims = Jwts.parserBuilder().setSigningKey(genSignInKey()).build().parseClaimsJws(token).getBody();

        var sub = claims.getSubject();
        var tExpiration = claims.getExpiration();

        return sub.equals(userId) && !tExpiration.before(new Date());
    }

    private Key genSignInKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
    }

}
