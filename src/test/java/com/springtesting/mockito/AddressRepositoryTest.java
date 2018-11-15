package com.springtesting.mockito;

import com.springtesting.model.Address;
import com.springtesting.model.AddressType;
import com.springtesting.repo.AddressRepository;
import com.springtesting.repo.AddressTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "integrationtest")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressRepositoryTest
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressTypeRepository addressTypeRepository;


    @Autowired
    private JpaTransactionManager jpaTransactionManager;

    @Test
    public void createPerson()
    {
        Address address=new Address();
        AddressType addressType = findOrCreateAddressType("Home");
        address.setStreetName("3130 Fair");
        address.setCity("Fairfax");
        address.setState("VA");
        address.setCountry("USA");
        address.setAddressType(addressType);
        address=addressRepository.saveAndFlush(address);
    }

    private AddressType findOrCreateAddressType(String type)
    {
        Optional<AddressType> addressTypeOptional=addressTypeRepository.findAddressTypeByType(type);
        if(addressTypeOptional.isPresent())
            return addressTypeOptional.get();
        else
            return addressTypeRepository.saveAndFlush(new AddressType(type));

    }

}
