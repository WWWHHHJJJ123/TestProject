package com.whj.ouath2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author CiZhong
 * @since 2026/1/16 18:04
 */
@Configuration
@EnableOAuth2Client
public class OAuth2ClientConfig {

    @Bean
    public OAuth2ProtectedResourceDetails clientCredentialsResourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setAccessTokenUri("http://localhost:8080/oauth/token");
        details.setClientId("client");
        details.setClientSecret("secret");
        details.setGrantType("client_credentials");
        details.setScope(Arrays.asList("read", "write"));
        return details;
    }

    @Bean
    public RestTemplate restTemplate(OAuth2ClientContext oauth2ClientContext) {
        return new OAuth2RestTemplate(clientCredentialsResourceDetails(), oauth2ClientContext);
    }
}