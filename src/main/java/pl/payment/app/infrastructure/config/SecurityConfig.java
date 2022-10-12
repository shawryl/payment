package pl.payment.app.infrastructure.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().httpBasic();
    }
}
