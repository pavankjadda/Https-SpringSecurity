package com.springtesting.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "country")
@Data
public class Country
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "name")
    @Length(max = 200,min = 2)
    private String name;

    @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
    private Set<State> cities=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    public Country() {};

    public Country(@Length(max = 100, min = 2) String name, Set<State> cities, Region region)
    {
        this.name = name;
        this.cities = cities;
        this.region = region;
    }
}
