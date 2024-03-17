package com.ecm.users;

import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public interface UserService {
  Optional<User> getUser(UserDTO userDTO);

  User addUser(UserDTO userDTO) throws EntityNotFoundException;
}
