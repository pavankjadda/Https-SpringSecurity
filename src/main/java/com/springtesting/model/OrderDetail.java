package com.springtesting.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "order_detail")
public class OrderDetail
{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
            name = "order_detail_products_list",
            joinColumns = @JoinColumn(name = "order_detail_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "products_list_id", referencedColumnName = "id"))
    private List<Product> productList = new ArrayList<>();


    public OrderDetail() {}

}
