package io.pan.graphapi.starter.application;

import com.microsoft.graph.models.extensions.IGraphServiceClient;
import com.microsoft.graph.requests.extensions.GraphServiceClient;
import io.pan.graphapi.authentication.TokenCache;
import io.pan.graphapi.authentication.request.credential.ApplicationCredential;
import io.pan.graphapi.starter.AuthenticationProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "graph-api", name = "onlyDelegate", havingValue = "false", matchIfMissing = true)
@EnableConfigurationProperties(ApplicationGraphApiProperties.class)
public class ApplicationGraphClientConfiguration {

  private final ApplicationCredential credentials;

  public ApplicationGraphClientConfiguration(ApplicationCredential credentials) {
    this.credentials = credentials;
  }

  @Bean("applicationGraphClient")
  public IGraphServiceClient graphClient() {
    return GraphServiceClient.builder()
        .authenticationProvider(
            new AuthenticationProvider(
                new TokenCache(credentials)
            )
        ).buildClient();
  }
}
