package com.springtesting.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "order_detail")
public class OrderDetail
{

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "order_status")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "purchased_By")
    private UserProfile purchasedBy;

    @ManyToOne
    @JoinColumn(name = "shipping_address")
    private Address address;

    @Column(name = "order_created_date_time")
    private LocalDateTime localDateTime;

    @ManyToMany
    @JoinTable(
            name = "order_detail_productlist",
            joinColumns = @JoinColumn(name = "order_detail_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productlist_id", referencedColumnName = "id"))
    private Set<Product> productlist = new HashSet<Product>();


    public OrderDetail() {}


    public OrderDetail(String id, UserProfile purchasedBy, LocalDateTime localDateTime,Address address,OrderStatus orderStatus)
    {
        this.id = id;
        this.orderStatus=orderStatus;
        this.localDateTime=localDateTime;
        this.purchasedBy = purchasedBy;
        this.address = address;
    }

    public OrderDetail(String id, OrderStatus orderStatus, UserProfile purchasedBy, Address address, LocalDateTime localDateTime, Set<Product> productlist)
    {
        this.id = id;
        this.orderStatus = orderStatus;
        this.purchasedBy = purchasedBy;
        this.address = address;
        this.localDateTime = localDateTime;
        this.productlist = productlist;
    }
}