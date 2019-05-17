package com.pj.springsecurity.https.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "region")
@Data
public class Region
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "name")
    @Length(max = 20,min = 2)
    private String name;

    public Region() {}

    public Region(@Length(max = 20, min = 2) String name)
    {
        this.name = name;
    }
}
