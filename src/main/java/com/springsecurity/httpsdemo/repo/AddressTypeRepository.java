package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressTypeRepository extends JpaRepository<AddressType,Long>
{
    Optional<AddressType> findAddressTypeByType(String type);
}
