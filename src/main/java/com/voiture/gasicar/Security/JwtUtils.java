package com.voiture.gasicar.Security;

import java.security.Key;
import java.util.Date;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.voiture.gasicar.Model.User;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
  
  private String jwtSecret="======================Yohan=Spring===========================";

  private int jwtExpirationMs=86400000;

  public static String getToken(HttpServletRequest request){
    String token="";
    if (request.getHeader("authorization")!=null&&request.getHeader("authorization")!="") {
        token=request.getHeader("authorization");
    }
    return token;
  }

  public String generateJwtToken(User user) {
    System.out.println(user.getRole());
    return Jwts.builder()
        .setSubject((user.getId()))
        .claim("role", user.getRole())
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
        .signWith(key(), SignatureAlgorithm.HS256)
        .compact();
  }
  
  private Key key() {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public String getUserIdFromToken(String token) {
    return Jwts.parserBuilder().setSigningKey(key()).build()
               .parseClaimsJws(token).getBody().getSubject();
          
  }

  public String getRoleFromToken(String token){
      return Jwts.parserBuilder().setSigningKey(key()).build()
      .parseClaimsJws(token).getBody().get("role").toString();
  }

  public boolean validateJwtToken(String authToken) throws Exception{
    try {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    } catch (Exception e){
      throw e;
    }
  }
}
