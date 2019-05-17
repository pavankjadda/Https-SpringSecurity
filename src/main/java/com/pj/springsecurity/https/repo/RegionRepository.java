package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region,Long>
{
    Optional<Region> findByName(String name);
}
