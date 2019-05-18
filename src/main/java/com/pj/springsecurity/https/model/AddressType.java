package com.pj.springsecurity.https.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "address_type")
public class AddressType implements Serializable
{
    private static final long serialVersionUID = 4381043207138882281L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    public AddressType()
    {

    }

    public AddressType(String type)
    {
        this.type = type;
    }
}
