package com.springtesting.mockito;

import com.springtesting.SpringtestingApplication;
import com.springtesting.mockito.springbootmysqltests.MysqlJpaConfig;
import com.springtesting.model.Address;
import com.springtesting.model.AddressType;
import com.springtesting.repo.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = {SpringtestingApplication.class,MysqlJpaConfig.class})
public class AddressRepositoryTest
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private JpaTransactionManager jpaTransactionManager;

    @Test
    public void createPerson()
    {
        Address address=new Address();
        //AddressType addressType=new AddressType("Home");
        AddressType addressType = findOrCreateAddressType("Home");

        address.setStreetName("3130 Fair");
        address.setCity("Fairfax");
        address.setState("VA");
        address.setCountry("USA");
        address.setAddressType(addressType);

        address=addressRepository.save(address);
        System.out.println("address=> "+address.toString());

    }

    public AddressType findOrCreateAddressType(String type)
    {
        AddressType addressType=null;
        EntityManagerFactory entityManagerFactory=jpaTransactionManager.getEntityManagerFactory();
        EntityManager entityManager= null;
        if (entityManagerFactory != null)
        {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query=entityManager.createNativeQuery("SELECT * FROM address_type WHERE type=:1",AddressType.class);
            query.setParameter(1,type);
            if(query.getResultList().size() > 0)
            {
                System.out.println("query.getResultList() => "+query.getResultList().toString());
                List<AddressType> addressTypeList= (List<AddressType>) query.getResultList();
                addressType=addressTypeList.get(0);
            }
            else
            {
                addressType=new AddressType(type);
                entityManager.persist(addressType);

            }
        }
        return addressType;

    }
}
