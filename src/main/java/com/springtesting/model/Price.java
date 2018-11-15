package com.springtesting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springtesting.model.orderhistory.Currency;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "price")
@Data
public class Price
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(name = "amount",nullable = false)
    private Double amount;

    @ManyToMany
    @JsonBackReference
    private Set<Product> productSet=new HashSet<>();

}
