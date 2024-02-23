package seventh.hometask.authorizationserver.SemSeventhHomeTask.ConfAuth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;


import java.util.UUID;



@Configuration
@RequiredArgsConstructor
//@Configuration
//@Import(OAuth2AuthorizationServerConfiguration.class)
public class AuthorizationServerConfig {

    private final AuthorizationSecurityProperty authorizationServerProperties;
    @Bean
    public SecurityFilterChain authSecurityFilterChain(HttpSecurity http)throws Exception{
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
        http.exceptionHandling(exception ->
                exception.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")));
        return http.build();
    }
    @Bean
    public RegisteredClientRepository registeredClientRepository(){
        RegisteredClient registeredClient = RegisteredClient.withId("test-client-id")
                                                                .clientName("Test Client")
                                                                .clientId("test-client")
                                                                .clientSecret("{noop}test-client")
                                                                .redirectUri("http://localhost:7000/index")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .build();

        return new InMemoryRegisteredClientRepository(registeredClient);
    }

    @Bean
    public AuthorizationServerSettings authorizationServerSettings(){
        System.out.printf("Print for debug: %s\n",authorizationServerProperties.getIssuerUrl());
        return AuthorizationServerSettings.builder().issuer(authorizationServerProperties.getIssuerUrl()).build();
    }


//    @Bean
//    public RegisteredClientRepository registeredClientRepository() {
//        return new InMemoryRegisteredClientRepository(
//                RegisteredClient.withId("test-client-id")
//                        .clientName("Test Client")
//                        .clientId("test-client")
//                        .clientSecret("{noop}test-client")
//                        .redirectUri("http://localhost:8080/")
//                        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                        .build());
//    }

    @Bean
    PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }


}
