package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>
{
}
