package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.Country;
import com.pj.springsecurity.https.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State,Long>
{
    Optional<State> findByNameAndCountry(String name, Country country);

    Optional<State> findByName(String name);
}
