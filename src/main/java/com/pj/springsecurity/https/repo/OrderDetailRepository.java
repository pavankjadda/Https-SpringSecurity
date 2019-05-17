package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>
{
}
