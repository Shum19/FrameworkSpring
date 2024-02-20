package seventh.hometask.resourceserver.SemSeventhHomeTask.Config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import seventh.hometask.resourceserver.SemSeventhHomeTask.servicies.UserService;

@Configurable
@EnableWebSecurity
@Data
public class SecurityConf {
    UserService userService;

    /**
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize)->authorize
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(String name) {
        UserDetails userDetails = User.withUsername(userService.findByName(name).getName())
                                    .password(userService.findByName(name).getPassword()).build();
        return new InMemoryUserDetailsManager(userDetails);
    }
}
