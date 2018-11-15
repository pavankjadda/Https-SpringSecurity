package com.springtesting.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "state")
@Data
public class State
{
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    @Length(max = 200,min = 2)
    private String name;

    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    private Set<City> cities=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;


    public State() {}

    public State(@Length(max = 100, min = 2) String name, String code, Set<City> cities, Country country)
    {
        this.name = name;
        this.code=code;
        this.cities = cities;
        this.country = country;
    }
}
