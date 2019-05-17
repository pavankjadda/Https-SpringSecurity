package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.City;
import com.springsecurity.httpsdemo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long>
{
    Optional<City> findByNameAndState(String name, State state);

    Optional<City> findByName(String name);

}
