package com.springtesting.dto;

import com.springtesting.model.Address;
import com.springtesting.model.OrderStatus;
import com.springtesting.model.Product;
import com.springtesting.model.UserProfile;
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
