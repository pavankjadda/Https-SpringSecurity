package com.springtesting.model.orderhistory;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "order_history")
@Data
public class OrderHistory
{
    @Id
    private String Id;

    @ManyToOne
    @JoinColumn(name = "order_history_address_id")
    private OrderHistoryAddress orderHistoryAddress;

    @ManyToOne
    @JoinColumn(name = "order_history_user_profile")
    private OrderHistoryUserProfile orderHistoryUserProfile;


}
