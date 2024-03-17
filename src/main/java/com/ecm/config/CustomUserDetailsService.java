package com.ecm.config;

import com.ecm.users.User;
import com.ecm.users.UserDTO;
import com.ecm.users.UserDetailsImpl;
import com.ecm.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> retrievedUser = userService.getUser(new UserDTO(username, null, null));
    return retrievedUser.map(UserDetailsImpl::new).orElse(null);
  }
}
