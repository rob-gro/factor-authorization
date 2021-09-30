package com.robgro.factorauthorization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//5. zapisanie usera do DB i pobranie danych
@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    Optional <AppUser> findByUserName(String userName);
}
