package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductPriceRepository extends JpaRepository<ProductPrice,Long>
{
    Optional<ProductPrice> findByProductIdAndPriceId(Long productId, Long priceId);
}
