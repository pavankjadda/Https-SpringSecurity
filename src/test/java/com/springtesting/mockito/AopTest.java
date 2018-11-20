package com.springtesting.mockito;

import com.springtesting.model.Address;
import com.springtesting.model.Product;
import com.springtesting.repo.AddressRepository;
import com.springtesting.repo.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopTest
{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Test
    public void getAddresses()
    {
        //addressRepository.findAll(PageRequest.of(0,20, Sort.by("id")));
        addressRepository.findAll();
    }


    @Test
    public void findAddressById()
    {
        addressRepository.findById(1L);
    }

    @Test
    public void testAop()
    {
        Product product=productRepository.findById("p1001").orElse(null);
    }

    @Test
    public void getAllProducts()
    {
        List<Product> productList=productRepository.findAll();
        for (Product product:productList)
            System.out.println(product.toString());
    }
}
