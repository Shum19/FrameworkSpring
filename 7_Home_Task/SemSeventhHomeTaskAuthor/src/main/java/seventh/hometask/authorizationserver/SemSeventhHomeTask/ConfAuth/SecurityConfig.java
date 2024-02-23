package seventh.hometask.authorizationserver.SemSeventhHomeTask.ConfAuth;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                                    authorize.anyRequest().authenticated());
        return http.formLogin(Customizer.withDefaults()).build();

    }
    //    @Bean
//    public SecurityFilterChain filterChainUser (HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .requestMatchers( "/index").hasAnyRole("USER")
//                        .requestMatchers("/h2-console").hasAnyRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .formLogin(login -> login
//
//                        .defaultSuccessUrl("/h2-console")
//                        )
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/"));
//
//        return http.build();
//        }
}
