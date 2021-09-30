package com.robgro.factorauthorization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    // 8. wstrzykujemy repozytorium
    AppUserRepo appUserRepo;

    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    // 7. Warstwa komunikacji pomiędzy Repozytorium z danymi a WebSecurityConfig z SS
        @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("Currently I'm in loadUserByUserName in UserDetailsServiceImpl ----> does it work ???? ");
        // todo orElseThrow.
        return appUserRepo.findByUserName(s).get();
            }
}
