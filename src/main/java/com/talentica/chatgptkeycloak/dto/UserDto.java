package com.talentica.chatgptkeycloak.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


public class UserDto {

  @NotBlank(message = "Username is required")
  private String username;
  @NotBlank(message = "Email is required")
  @Email(message = "Invalid email address")
  private String email;
  @NotBlank(message = "First name is required")
  private String firstName;

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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}