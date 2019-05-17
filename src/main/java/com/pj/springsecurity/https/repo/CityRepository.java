package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.City;
import com.pj.springsecurity.https.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Long>
{
    Optional<City> findByNameAndState(String name, State state);

    Optional<City> findByName(String name);

}
