package com.robgro.factorauthorization;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Collections;

// 2.  klasa tworząca użytkowników
@Getter
@Setter
@Entity     // utworzenie encji w bazie danych
public class AppUser implements UserDetails {

    private static final Logger log = LoggerFactory.getLogger(AppUser.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatyczne inkrementowanie Id
    private Long id;

    private String userName;
    private String password;
    private String role;

    @Override   // 3. "rola" użytkownika, zwraca Collection, dlatego trzeba opakować Wrapem
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("---->  AppUser.class, Collection with 'role' has started");
        return Collections.singleton(new SimpleGrantedAuthority("role"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    // 4. na poczatek zmieniamy na "true", aby się nie bawić
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}