package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>
{


}
