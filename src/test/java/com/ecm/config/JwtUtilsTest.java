package com.ecm.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {
  private final JwtUtils jwt = new JwtUtils();

  @Test
  public void testCreate() {
    String token = jwt.create("hello");
    System.out.println(token);
  }

  @Test
  public void testVerifySuccessfully() {
    String token = jwt.create("username");
    jwt.verify("username", token);
  }

  @Test
  public void testVerifyUnsuccessfully() {
    String token = jwt.create("username");
    assertThrows(JWTVerificationException.class, () -> jwt.verify("username1", token));
  }
}