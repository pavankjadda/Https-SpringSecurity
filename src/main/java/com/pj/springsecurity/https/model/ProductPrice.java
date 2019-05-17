package com.pj.springsecurity.https.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "product_price")
@Data
public class ProductPrice
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_id",nullable = false)
    private long productId;

    @Column(name = "price_id",nullable = false)
    private long priceId;

    public ProductPrice()
    {
    }

    public ProductPrice(long productId, Long priceId)
    {
        this.productId = productId;
        this.priceId = priceId;
    }
}
