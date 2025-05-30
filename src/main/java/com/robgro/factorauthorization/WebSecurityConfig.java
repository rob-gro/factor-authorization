package com.robgro.factorauthorization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 1. klasa konfigurująca całą aplikację
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter { // --> zestaw implementacji security

    // 10 . przechowywanie hasła użytkownika w postaci zaszyfrowanej
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 9. wstrzykujemy
    private UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override   // zarządzanie użytkownikami
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 6. połączenie między repo a spring security (SS), "userDetailsService" --> dostarcza info o userach
        auth.userDetailsService(userDetailsService);
    }

    // 12. ustawienia zabezpieczeń
    @Override   // zarządzanie zabezpieczeniami na poziomie HTTP
    protected void configure(HttpSecurity http) throws Exception {
        // 13. musimy poniższe wyłączyć, aby mieć dostęp do bazy H2
        http.csrf().disable();
        http.headers().disable();

        // 15. dodajemy autoryzację userów
        http.authorizeRequests()
                .antMatchers("/hello").authenticated()
                .antMatchers("/for-admin").hasRole("ADMIN")
                .antMatchers("/for-user").hasAuthority("ROLE_USER")

                // 16. dodanie formatki logowania
                .and()
                .formLogin().defaultSuccessUrl("/hello");
    }
}
