package com.springsecurity.httpsdemo.dto;

import com.springsecurity.httpsdemo.model.UserProfile;
import com.springsecurity.httpsdemo.model.Address;
import com.springsecurity.httpsdemo.model.OrderStatus;
import com.springsecurity.httpsdemo.model.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDetailDTO
{
    private long id;

    private OrderStatus orderStatus;

    private UserProfile purchasedBy;

    private Address address;

    private LocalDateTime localDateTime;

    private List<Product> productList;
}
