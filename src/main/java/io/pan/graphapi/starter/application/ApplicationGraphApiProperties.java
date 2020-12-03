package io.pan.graphapi.starter.application;

import io.pan.graphapi.authentication.request.credential.ApplicationCredential;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConstructorBinding
@ConfigurationProperties("graph-api")
public class ApplicationGraphApiProperties implements ApplicationCredential {

  private final String clientId;
  private final String clientSecret;
  private final List<String> scopes;
  private final String nationalCloud;
  private final String tenant;

  public ApplicationGraphApiProperties(String clientId, String clientSecret, List<String> scopes, String nationalCloud, String tenant) {
    this.clientId = clientId;
    this.clientSecret = clientSecret;
    this.scopes = scopes;
    this.nationalCloud = nationalCloud;
    this.tenant = tenant;
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
}
