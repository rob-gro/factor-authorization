package com.robgro.factorauthorization;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

// 11. tworzenie użytkowników
@Configuration
public class Bootstrap {

    public Bootstrap(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {

        AppUser appUserRob = new AppUser();
        appUserRob.setUserName("Rob");
        appUserRob.setPassword(passwordEncoder.encode("Rob6"));
        appUserRob.setRole("ROLE_ADMIN");

        AppUser appUserTom = new AppUser();
        appUserTom.setUserName("Tom");
        appUserTom.setPassword(passwordEncoder.encode("Tom6"));
        appUserTom.setRole("ROLE_USER");

        appUserRepo.save(appUserRob);
        appUserRepo.save(appUserTom);
    }
}