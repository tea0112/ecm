package com.ecm.users;

import com.ecm.roles.Role;
import com.ecm.roles.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public Optional<User> getUser(UserDTO userDTO) {
    return userRepository.findByUsername(userDTO.getUsername());
  }

  @Override
  public User addUser(UserDTO userDTO) throws EntityNotFoundException {
    Role role = roleRepository.findByName("user").orElseThrow(EntityNotFoundException::new);

    User newUser = new User();
    newUser.setEmail(userDTO.getEmail());
    newUser.setUsername(userDTO.getUsername());
    newUser.setPassword(userDTO.getPassword());
    newUser.setRole(role);

    newUser = userRepository.save(newUser);

    return newUser;
  }
}
