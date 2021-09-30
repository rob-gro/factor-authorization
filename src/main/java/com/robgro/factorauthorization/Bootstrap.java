package com.robgro.factorauthorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

// 11. tworzenie użytkowników
@Configuration
public class Bootstrap {

    public Bootstrap(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {

        AppUser appUser = new AppUser();
        appUser.setUserName("Rob");
        appUser.setPassword(passwordEncoder.encode("Rob6"));
        appUser.setRole("ROLE_ADMIN");
        appUserRepo.save(appUser);

    }
}
