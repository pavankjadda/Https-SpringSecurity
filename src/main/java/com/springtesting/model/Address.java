package com.springtesting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_code")
    private String zipCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_type_id",referencedColumnName = "id")
    private AddressType addressType;

    public Address()
    {
    }

    public Address(String streetName, String apartment, String city, String state, String country, String zipCode, AddressType addressType)
    {
        this.streetName = streetName;
        this.apartment = apartment;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.addressType = addressType;
    }
}
