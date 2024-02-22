package seventh.hometask.resourceserver.SemSeventhHomeTask.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;


@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    // @formatter:off
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .mvcMatcher("/messages/**")
                .authorizeRequests()
                .mvcMatchers("/messages/**").access("hasAuthority('SCOPE_message.read')")
                .and()
                .oauth2ResourceServer();
    }

    // @formatter:on
}
