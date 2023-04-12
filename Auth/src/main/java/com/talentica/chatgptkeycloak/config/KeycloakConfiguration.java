package com.talentica.chatgptkeycloak.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

  private final String serverUrl;
  private final String realm;
  private final String clientId;
  private final String username;
  private final String password;

  public KeycloakConfiguration(@Value("${keycloak.auth-server-url}") String serverUrl,
      @Value("${keycloak.realm}") String realm,
      @Value("${kc.admin.client-id}") String clientId,
      @Value("${kc.admin.username}") String username,
      @Value("${kc.admin.password}") String password) {
    this.serverUrl = serverUrl;
    this.realm = realm;
    this.clientId = clientId;
    this.username = username;
    this.password = password;
  }

  @Bean
  public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }

  @Bean
  public org.keycloak.admin.client.Keycloak keycloak() {
    return KeycloakBuilder.builder()
        .serverUrl(serverUrl)
        .realm(realm)
        .clientId(clientId)
        .username(username)
        .password(password)
        .build();
  }
}
