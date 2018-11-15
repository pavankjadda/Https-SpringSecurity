package com.springtesting.repo;

import com.springtesting.model.Address;
import com.springtesting.model.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long>
{
}
