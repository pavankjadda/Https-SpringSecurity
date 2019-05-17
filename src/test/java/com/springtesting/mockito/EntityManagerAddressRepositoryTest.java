package com.springtesting.mockito;

import com.springtesting.SpringTestingApplication;
import com.springtesting.mockito.nonspringboottests.MysqlJpaConfig;
import com.springtesting.model.Address;
import com.springtesting.model.AddressType;
import com.springtesting.repo.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


// This class focuses on updating database using Entity Manager rather than Spring Data
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringTestingApplication.class,MysqlJpaConfig.class})
public class EntityManagerAddressRepositoryTest
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private JpaTransactionManager jpaTransactionManager;

    @Test
    public void createPerson()
    {
        Address address=new Address();
        AddressType addressType = findOrCreateAddressType("Home");
        address.setStreetName("3130 Fair");
        address.setAddressType(addressType);

        saveOrMergeAddress(address);

    }

    public AddressType findOrCreateAddressType(String type)
    {
        AddressType addressType=null;
        try
        {
            EntityManagerFactory entityManagerFactory=jpaTransactionManager.getEntityManagerFactory();
            EntityManager entityManager;
            if (entityManagerFactory != null)
            {
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                //addressType=entityManager.createQuery("from AddressType where ",AddressType.class).getSingleResult();
                List<AddressType> addressTypeList= entityManager.createQuery( "SELECT at FROM AddressType at WHERE at.type LIKE :type",AddressType.class).setParameter("type", type).getResultList();
                if(addressTypeList.size()>0 && addressTypeList.get(0)!=null && !addressTypeList.get(0).getType().equals(""))
                    return addressTypeList.get(0);
                else
                {
                    addressType=new AddressType(type);
                    //entityManager.persist(addressType);
                    //entityManager.getTransaction().commit();
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

            return null;
        }

        return addressType;

    }

    // Save or Merge (update) object through  Entity Manager
    public void saveOrMergeAddress(Address address)
    {
        try
        {
            EntityManagerFactory entityManagerFactory=jpaTransactionManager.getEntityManagerFactory();
            EntityManager entityManager;
            if (entityManagerFactory != null)
            {
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                entityManager.merge(address);
                entityManager.getTransaction().commit();
                entityManager.close();

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        System.out.println("address=> "+address.toString());
    }
}
