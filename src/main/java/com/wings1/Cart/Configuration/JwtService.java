package com.wings1.Cart.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

@Component
public class JwtService {

    private static final String SECRET = "ThisIsASecretThisIsASecretThisIsASecretThisIsASecret";
    private static final Long JWT_EXPIRE = 900000000l;

    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    // springboot version 3.3.0
//private Claims extractAllClaims(String token){
//    return Jwts.parser().setSigningKey(SECRET)
//            .getBody()
//            .parseClaimsJws(token)
//            .getBody();
//}

    public String extractUsername(String token){
        Claims claim = extractAllClaims(token);
        return claim.getSubject();
    }

    public Date extractExpiry(String token){
        Claims claim = extractAllClaims(token);
        return claim.getExpiration();
    }

    public String generateToken(UserDetails user){
        return Jwts.builder().signWith(SignatureAlgorithm.HS256,SECRET)
                .setClaims(new HashMap<>())
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRE))
                .compact();
    }

    public boolean validateToken(String token, UserDetails user){
        String username = extractUsername(token);
        Date expiry = extractExpiry(token);
        if(username.equals(user.getUsername()) && expiry.after(new Date(System.currentTimeMillis()))){
            return true;
        }
        return false;
    }

    // For verification
//    public static void main( String args[]){
//        UserDetails userDetails = new User("Ven","pass", Set.of(new SimpleGrantedAuthority("ADMIN")));
//        JwtService service = new JwtService();
//        String token = service.generateToken(userDetails);
//        System.out.println(token);
//        System.out.println(service.extractUsername(token));
//        System.out.println(service.extractExpiry(token));
//        System.out.println(service.validateToken(token, userDetails));
//    }
}
