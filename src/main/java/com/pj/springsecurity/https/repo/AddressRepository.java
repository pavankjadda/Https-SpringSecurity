package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long>
{
}
