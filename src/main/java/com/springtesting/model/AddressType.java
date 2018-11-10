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
    @Column(name = "address_type_id")
    private Long addressTypeId;

    @Column(name = "type")
    @NonNull
    private String type;

    public AddressType()
    {

    }

    public AddressType(String type)
    {
    }
}
