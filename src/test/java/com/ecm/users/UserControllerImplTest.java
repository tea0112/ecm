package com.ecm.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {UserControllerImpl.class})
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class UserControllerImplTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserService mockUserService;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  public void testAddUser() throws Exception {
    UserDTO userDTO = new UserDTO("new_user", "new_user_email@gmail.com", "New_user!23456");
    User newUser = new User("new_user", "new_user_email@gmail.com", "New_user!23456");
    Mockito.when(mockUserService.addUser(any())).thenReturn(newUser);

    this.mockMvc.perform(post("/users/register")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(userDTO)))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.username").value("new_user"));
  }
}