package com.pj.springsecurity.https.repo;


import com.pj.springsecurity.https.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long>
{
}
