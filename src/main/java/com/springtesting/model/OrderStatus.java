package com.springtesting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_status")
public class OrderStatus
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "status")
    private String status;

    public OrderStatus() {};

    public OrderStatus(String status)
    {
        this.status = status;
    }
}
