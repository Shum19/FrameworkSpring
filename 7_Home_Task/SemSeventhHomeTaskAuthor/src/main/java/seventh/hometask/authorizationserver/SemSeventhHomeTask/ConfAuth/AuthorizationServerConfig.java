package seventh.hometask.authorizationserver.SemSeventhHomeTask.ConfAuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;


import java.util.UUID;




@EnableWebSecurity
@Import(OAuth2AuthorizationServerConfiguration.class)
public class AuthorizationServerConfig {
//    @Bean
//    public RegisteredClientRepository registeredClientRepository(){
//        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                                                                .clientId("messaging-client")
//                                                                .clientSecret("secret")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .redirectUri("http://localhost:8080/authorized")
//                .scope("message.read")
//                .scope("message.write")
//                .build();
//
//        return new InMemoryRegisteredClientRepository(registeredClient);
//    }
    @Bean
    public RegisteredClientRepository registeredClientRepository() {
        return new InMemoryRegisteredClientRepository(
                RegisteredClient.withId("test-client-id")
                        .clientName("Test Client")
                        .clientId("test-client")
                        .clientSecret("test-client")
                        .redirectUri("http://localhost:8080")
                        .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                        .build());
    }

    @Bean
    PasswordEncoder encoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
