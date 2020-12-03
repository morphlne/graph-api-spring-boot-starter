package io.pan.graphapi.starter;

import com.microsoft.graph.authentication.IAuthenticationProvider;
import com.microsoft.graph.http.IHttpRequest;

import java.util.function.Supplier;

public class AuthenticationProvider implements IAuthenticationProvider {

  private final Supplier<String> token;
  private final String bearer;
  private final String authorizationHeader;

  public AuthenticationProvider(Supplier<String> token, String bearer, String authorizationHeader) {
    this.token = token;
    this.bearer = bearer;
    this.authorizationHeader = authorizationHeader;
  }

  public AuthenticationProvider(Supplier<String> token) {
    this(
        token,
        "Bearer ",
        "Authorization"
    );
  }

  @Override
  public void authenticateRequest(IHttpRequest request) {
    request.addHeader(authorizationHeader, bearer + token.get());
  }
}
