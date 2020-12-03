package io.pan.graphapi.starter.delegate;

import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import io.pan.graphapi.authentication.TokenCache;
import io.pan.graphapi.authentication.request.credential.UserCredential;
import io.pan.graphapi.starter.AuthenticationProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "graph-api", name = {"user", "password"})
@EnableConfigurationProperties(DelegateGraphApiProperties.class)
public class DelegateGraphClientConfiguration {

  private final UserCredential credentials;

  public DelegateGraphClientConfiguration(UserCredential credentials) {
    this.credentials = credentials;
  }

  @Bean("delegateGraphClient")
  public IGraphServiceClient graphClient() {
    return GraphServiceClient.builder()
        .authenticationProvider(
            new AuthenticationProvider(
                new TokenCache(credentials)
            )
        ).buildClient();
  }
}
