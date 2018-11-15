package com.springtesting.mockito;

import com.springtesting.SpringtestingApplication;
import com.springtesting.mockito.springbootmysqltests.MysqlJpaConfig;
import com.springtesting.model.Address;
import com.springtesting.model.AddressType;
import com.springtesting.repo.AddressRepository;
import com.springtesting.repo.AddressTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
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
