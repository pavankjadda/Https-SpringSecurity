package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.Country;
import com.pj.springsecurity.https.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long>
{
	Optional<Country> findByNameAndRegion(String name, Region region);

	Optional<Country> findByName(String name);
}
