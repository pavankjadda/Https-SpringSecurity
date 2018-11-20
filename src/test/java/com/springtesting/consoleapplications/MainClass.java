package com.springtesting.consoleapplications;

import com.springtesting.model.Product;

public class MainClass
{
    public static void main(String[] args)
    {
        Product product=new Product();
        product.setName("iPhone");

        System.out.println(product.getName());

    }
}
