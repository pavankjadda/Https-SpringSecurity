package com.springtesting.mockito;

import com.springtesting.model.*;
import com.springtesting.repo.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "integrationtest")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest
{
    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private Currency currency;

    private Price price;

    private Product product;

    @Before
    public void setUp()
    {
        String isoCode="USD";
        String name="US Dollar";
        String symbol="$";
        Double amount=349.99;
        Long prceId=34L;

        currency=findCurrency(isoCode);
        if(currency == null)
        {
            currency=new Currency(name,symbol,isoCode);
            currency=currencyRepository.saveAndFlush(currency);
        }

        price=findPrice(prceId);
        if(price == null)
        {
            price=new Price(currency,amount);
            price=priceRepository.saveAndFlush(price);
        }

    }

    @Test
    public void createProduct()
    {
        String productId="p1005";
        String name="Easy Keto Receipes";
        Category category=findCategory("cat1001");

        product=findProduct(productId);
        if(product == null)
        {
            product=new Product(productId,name,category);
            productRepository.saveAndFlush(product);
        }
        ProductPrice productPrice=productPriceRepository.findByProductIdAndPriceId(product.getId(),this.price.getId()).orElse(null);
        if(productPrice == null)
        {
            productPrice=new ProductPrice(product.getId(),this.price.getId());
            productPriceRepository.saveAndFlush(productPrice);
        }

    }

    private Product findProduct(String productId)
    {
        return productRepository.findById(productId).orElse(null);
    }

    private Category findCategory(String id)
    {
        return categoryRepository.findById(id).orElse(null);
    }

    private Currency findCurrency(String isoCode)
    {
        return currencyRepository.findByAndIsoCode(isoCode).orElse(null);
    }

    private Price findPrice(Long priceId)
    {
        return priceRepository.findById(priceId).orElse(null);
    }
}
