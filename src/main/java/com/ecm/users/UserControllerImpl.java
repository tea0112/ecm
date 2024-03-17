package com.ecm.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {
  @Autowired
  private UserService userService;
  @Override
  public User addUser(UserDTO userDTO) {
    return userService.addUser(userDTO);
  }
}
