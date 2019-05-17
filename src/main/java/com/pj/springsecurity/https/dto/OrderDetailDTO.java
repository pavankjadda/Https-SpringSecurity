package com.pj.springsecurity.https.dto;

import com.pj.springsecurity.https.model.Address;
import com.pj.springsecurity.https.model.OrderStatus;
import com.pj.springsecurity.https.model.Product;
import com.pj.springsecurity.https.model.UserProfile;
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
