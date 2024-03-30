package com.ecm.users;

import org.springframework.http.ResponseEntity;

public interface UserController {
  public ResponseEntity<User> addUser(UserDTO userDTO);
}
