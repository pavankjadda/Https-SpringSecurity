package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency,Long>
{
    Optional<Currency> findByAndIsoCode(String isoCode);
}
