package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.Country;
import com.springsecurity.httpsdemo.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country,Long>
{
    Optional<Country> findByNameAndRegion(String name, Region region);

    Optional<Country> findByName(String name);
}
