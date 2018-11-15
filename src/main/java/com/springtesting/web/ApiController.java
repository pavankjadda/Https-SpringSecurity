package com.springtesting.web;

import com.springtesting.model.*;
import com.springtesting.repo.CategoryRepository;
import com.springtesting.repo.OrderDetailProductRepository;
import com.springtesting.repo.OrderDetailRepository;
import com.springtesting.repo.ProductRepository;
import com.springtesting.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController
{
    private final PersonService personService;

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    private final OrderDetailRepository orderDetailRepository;

    private final OrderDetailProductRepository orderDetailProductRepository;

    public ApiController(PersonService personService, CategoryRepository categoryRepository, ProductRepository productRepository, OrderDetailRepository orderDetailRepository, OrderDetailProductRepository orderDetailProductRepository)
    {
        this.personService = personService;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.orderDetailProductRepository = orderDetailProductRepository;
    }

    //Category Controller Methods

    @PostMapping(value = "/category/create")
    public Category createNewCategory(@RequestBody Category category)
    {
        return categoryRepository.saveAndFlush(category);
    }

    @GetMapping(value = "/categories")
    public List<Category> listCategories()
    {
        return categoryRepository.findAll();
    }

    @GetMapping(value = "/category/{id}")
    public Optional<Category> getCategory(@PathVariable String id)
    {
        return categoryRepository.findById(id);
    }



    //Product Controller methods

    @PostMapping(value = "/product/create")
    public Product createProduct(@RequestBody Product product)
    {
        return productRepository.saveAndFlush(product);
    }


    @GetMapping(value = "/products")
    public List<Product> listProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping(value = "/product/{id}")
    public Optional<Product> getProduct(@PathVariable String id)
    {
        return productRepository.findById(id);
    }


    //Order Detail Controller Methods

    @PostMapping(value = "/order/create")
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail)
    {
        return orderDetailRepository.saveAndFlush(orderDetail);
    }


    @GetMapping(value = "/orders")
    public List<OrderDetail> listOrderDetails()
    {
        return orderDetailRepository.findAll();
    }

    @GetMapping(value = "/order/{id}")
    public Optional<OrderDetail> getOrderDetail(@PathVariable String id)
    {
        return orderDetailRepository.findById(id);
    }

    //Customer Order Products Controller methods


    @GetMapping(value = "/orderproducts/{orderId}")
    public List<OrderDetailProduct> getOrdersAndProducts(@PathVariable String orderId)
    {
        return orderDetailProductRepository.findByOrderDetailId(orderId);
    }



    //Person Controller methods

    @GetMapping(value = "/person/{id}")
    public Person getPersonById(@PathVariable   String  id)
    {
        return personService.getPersonById(id);
    }

    @GetMapping(value = "/persons")
    public List<Person> getPersons()
    {
        return personService.getPersons();
    }

    @PostMapping(value = "/person/create")
    public Person getPersons(@RequestBody   Person  person)
    {
        return personService.createPerson(person);
    }
}
