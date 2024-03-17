package com.ecm.roles;

import com.ecm.users.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
  private Collection<User> users;

  public Role() {
  }

  public Role(String name) {
    this.name = name;
  }
}
