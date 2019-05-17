package com.pj.springsecurity.https.web;

import com.pj.springsecurity.https.model.Product;
import com.pj.springsecurity.https.repo.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository)
    {
        this.productRepository=productRepository;
    }

    @PostMapping(path = "/create")
    public void createProduct(@RequestBody Product Product)
    {
        productRepository.saveAndFlush(Product);
    }

    @GetMapping(value = "/list")
    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public Optional<Product> getProductById(@PathVariable long id)
    {
        return productRepository.findById(id);
    }

}
