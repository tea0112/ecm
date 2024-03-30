package com.ecm.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerImpl implements UserController {
  @Autowired
  private UserService userService;

  @PostMapping("/register")
  @Override
  public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
    User newUser = userService.addUser(userDTO);
    if (newUser == null) return ResponseEntity.badRequest().build();
    else
      return ResponseEntity.ok(userService.addUser(userDTO));
  }

  @PostMapping("/signin")
  public ResponseEntity signin(@RequestBody UserDTO userDTO) {
    return null;
  }
}
