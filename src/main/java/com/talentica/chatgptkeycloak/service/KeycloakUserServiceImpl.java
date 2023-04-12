// KeycloakUserServiceImpl.java
package com.talentica.chatgptkeycloak.service;

import com.talentica.chatgptkeycloak.dto.CreateUserRequest;
import com.talentica.chatgptkeycloak.dto.TokenResponse;
import java.util.HashMap;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.authorization.client.util.Http;

import javax.ws.rs.core.Response;
import java.util.Collections;

@Service
public class KeycloakUserServiceImpl implements UserService {

  private final Keycloak keycloak;
  private final String realm;
  private final String clientId;
  private final String serverUrl;

  public KeycloakUserServiceImpl(Keycloak keycloak, @Value("${keycloak.realm}") String realm, @Value("${kc.admin.client-id}")String clientId, @Value("${keycloak.auth-server-url}") String serverUrl) {
    this.keycloak = keycloak;
    this.realm = realm;
    this.clientId = clientId;
    this.serverUrl = serverUrl;
  }

  @Override
  public void createUser(CreateUserRequest createUserRequest) {
    UserRepresentation user = new UserRepresentation();
    user.setUsername(createUserRequest.getUsername());
    user.setEmail(createUserRequest.getEmail());
    user.setEnabled(false); // The user will be enabled after email verification
    user.setAttributes(Collections.singletonMap("emailVerified", Collections.singletonList("false")));

    CredentialRepresentation credential = new CredentialRepresentation();
    credential.setType(CredentialRepresentation.PASSWORD);
    credential.setValue("dummy"); // Set a dummy password, it will not be used as Keycloak handles password reset
    credential.setTemporary(true); // Mark the password as temporary to force the user to reset it

    user.setCredentials(Collections.singletonList(credential));

    RealmResource realmResource = keycloak.realm(realm);
    UsersResource usersResource = realmResource.users();
    Response response = usersResource.create(user);

    if (response.getStatus() != Response.Status.CREATED.getStatusCode()) {
      throw new RuntimeException("Failed to create user");
    }

    String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
    UserResource userResource = usersResource.get(userId);
    userResource.executeActionsEmail(Collections.singletonList("VERIFY_EMAIL"));
  }

  @Override
  public TokenResponse getToken(String username, String password) {
    Configuration configuration = new Configuration(
        serverUrl,
        realm,
        clientId,
        new HashMap<>(),
        null);

    AuthzClient authzClient = AuthzClient.create(configuration);

    AccessTokenResponse accessTokenResponse;
    try {
      accessTokenResponse = authzClient.obtainAccessToken(username, password);
    } catch (Exception e) {
      throw new RuntimeException("Failed to obtain access token", e);
    }

    TokenResponse tokenResponse = new TokenResponse();
    tokenResponse.setAccessToken(accessTokenResponse.getToken());
    tokenResponse.setRefreshToken(accessTokenResponse.getRefreshToken());
    tokenResponse.setTokenType(accessTokenResponse.getTokenType());
    tokenResponse.setExpiresIn((int)accessTokenResponse.getExpiresIn());

    return tokenResponse;
  }
}
