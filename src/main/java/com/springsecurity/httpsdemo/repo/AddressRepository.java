package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long>
{
}
