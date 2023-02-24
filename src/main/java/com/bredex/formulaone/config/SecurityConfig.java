package com.bredex.formulaone.config;

import com.bredex.formulaone.service.SecurityService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private SecurityService securityService;

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(@NotNull HttpSecurity http) throws Exception {
        return http.csrf(c -> c.ignoringAntMatchers("/h2-console/**", "/resources/**", "/static/**"))
                .authorizeRequests(a -> a
                        .antMatchers("/h2-console/**", "/resources/**").permitAll()
                        .antMatchers("/create/**", "/delete/**").hasAnyAuthority("ROLE_BOSS")
                        .antMatchers("/update/**").hasAnyAuthority("ROLE_BOSS", "ROLE_CLIENT"))
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/create", true).permitAll()
                .and()
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .deleteCookies()
                        .invalidateHttpSession(true)
                        .permitAll()
                )
                .headers(h -> h.frameOptions().sameOrigin())
                .userDetailsService(securityService)
                .build();
    }

}
