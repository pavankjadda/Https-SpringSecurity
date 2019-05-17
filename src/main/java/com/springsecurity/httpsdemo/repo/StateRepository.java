package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.Country;
import com.springsecurity.httpsdemo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State,Long>
{
    Optional<State> findByNameAndCountry(String name, Country country);

    Optional<State> findByName(String name);
}
