package com.talentica.chatgptkeycloak.service;

import com.talentica.chatgptkeycloak.dto.CreateUserRequest;
import com.talentica.chatgptkeycloak.dto.TokenResponse;

public interface UserService {

  void createUser(CreateUserRequest createUserRequest);
  TokenResponse getToken(String username, String password);

}
