package com.springtesting.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address_type")
public class AddressType
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address_type")
    @NonNull
    private String addressType;

    public AddressType()
    {

    }
}
