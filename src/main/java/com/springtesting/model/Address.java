package com.springtesting.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "address")
public class Address
{
    private String streetName;

    private String apartment;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "address_type_id")
    private AddressType addressType;




}
