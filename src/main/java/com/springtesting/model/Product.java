package com.springtesting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name ="product")
public class Product implements Serializable
{
    @Id
    private String id;

    @NotNull(message = "Product name must not be null")
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToMany
    @JoinTable(
        name = "product_prices",
        joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "price_id",referencedColumnName = "id")
        )
    @JsonManagedReference
    private Set<Price> priceSet=new HashSet<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "productlist")
    private List<OrderDetail> orderDetail =new ArrayList<OrderDetail>();
}