package com.ecm.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class JwtUtils {
  private final String SECRET = "Secret";
  private final Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

  public String create(String identity) {
    return JWT.create()
        .withIssuer(identity)
        .sign(ALGORITHM);
  }

  public void verify(String identity, String token) throws JWTVerificationException {
    JWTVerifier verifier = JWT.require(ALGORITHM)
        .withIssuer(identity)
        .build();
    verifier.verify(token);
  }
}
