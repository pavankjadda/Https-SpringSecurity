package com.springtesting.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "state")
@Data
public class State
{
    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    @Length(max = 200,min = 2)
    private String name;

/*    @OneToMany(mappedBy = "state",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<City> cities=new ArrayList<>();*/

    @ManyToOne
    @JoinColumn(name = "country_id")
    @JsonManagedReference
    private Country country;


    public State() {}

    public State(@Length(max = 100, min = 2) String name, String code, Country country)
    {
        this.name = name;
        this.code=code;
        this.country = country;
    }
}
