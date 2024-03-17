package com.ecm.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
  private Long id;
  private String username;
  private String email;
  private String password;

  public UserDTO() {
  }

  public UserDTO(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }
}
