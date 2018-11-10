package com.springtesting.mockito;

import com.springtesting.SpringtestingApplication;
import com.springtesting.model.Address;
import com.springtesting.model.AddressType;
import com.springtesting.repo.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class AddressRepositoryTest
{
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void createPerson()
    {
        Address address=new Address();
        AddressType addressType=new AddressType();

        addressType.setAddressType("Home");
        address.setStreetName("3130 Fair");
        address.setCity("Fairfax");
        address.setState("VA");
        address.setCountry("USA");
        address.setAddressType(addressType);

        address=addressRepository.save(address);

        System.out.println("address=> "+address.toString());

    }
}
