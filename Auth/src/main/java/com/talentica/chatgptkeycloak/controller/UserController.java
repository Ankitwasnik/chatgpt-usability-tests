package com.talentica.chatgptkeycloak.controller;

// UserController.java

import com.talentica.chatgptkeycloak.dto.CreateUserRequest;
import com.talentica.chatgptkeycloak.dto.TokenResponse;
import com.talentica.chatgptkeycloak.service.UserService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")
  public ResponseEntity<Void> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
    userService.createUser(createUserRequest);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/auth/token")
  public ResponseEntity<TokenResponse> getToken(
      @RequestParam("username") String username,
      @RequestParam("password") String password) {
    TokenResponse tokenResponse = userService.getToken(username, password);
    return ResponseEntity.ok(tokenResponse);
  }
}

