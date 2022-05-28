package com.springbootlearning.springbootandoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;

@Configuration
public class OAuth2Config {

  @Bean
  public OAuth2AuthorizedClientManager clientManager( //
    ClientRegistrationRepository clientRegistrationRepository, //
    OAuth2AuthorizedClientRepository authorizedClientRepository) {

    OAuth2AuthorizedClientProvider clientProvider = OAuth2AuthorizedClientProviderBuilder.builder() //
      .authorizationCode() //
      .refreshToken() //
      .clientCredentials() //
      .password() //
      .build();

    DefaultOAuth2AuthorizedClientManager clientManager = new DefaultOAuth2AuthorizedClientManager(
      clientRegistrationRepository, authorizedClientRepository);
    clientManager.setAuthorizedClientProvider(clientProvider);

    return clientManager;

  }
}
