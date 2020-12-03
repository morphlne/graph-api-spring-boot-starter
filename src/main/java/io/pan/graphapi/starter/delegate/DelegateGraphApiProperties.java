package io.pan.graphapi.starter.delegate;

import io.pan.graphapi.authentication.request.credential.UserCredential;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties("graph-api")
public class DelegateGraphApiProperties implements UserCredential {

  private final String clientId;
  private final String clientSecret;
  private final List<String> scopes;
  private final String nationalCloud;
  private final String tenant;
  private final String user;
  private final String password;

  public DelegateGraphApiProperties(String clientId, String clientSecret, List<String> scopes, String nationalCloud, String tenant, String user, String password) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.scopes = scopes;
    this.nationalCloud = nationalCloud;
    this.tenant = tenant;
    this.user = user;
    this.password = password;
  }

  @Override
  public String clientId() {
    return clientId;
  }

  @Override
  public String clientSecret() {
    return clientSecret;
  }

  @Override
  public List<String> scopes() {
    return scopes;
  }

  @Override
  public String tenant() {
    return tenant;
  }

  @Override
  public String nationalCloud() {
    return nationalCloud;
  }

  @Override
  public String user() {
    return user;
  }

  @Override
  public String password() {
    return password;
  }
}
