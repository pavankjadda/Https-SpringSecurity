package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long>
{


}
