// CreateUserRequest.java
package com.talentica.chatgptkeycloak.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CreateUserRequest {

  @NotBlank
  private String username;

  @NotBlank
  @Email
  private String email;

  // Getters and setters

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

