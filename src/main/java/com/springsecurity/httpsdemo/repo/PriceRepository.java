package com.springsecurity.httpsdemo.repo;


import com.springsecurity.httpsdemo.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long>
{
}
