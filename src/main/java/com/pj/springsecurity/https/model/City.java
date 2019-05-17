package com.pj.springsecurity.https.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Cache(region = "cityCache",usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class City
{
    private static final long serialVersionUID = -8825045541258851493L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    //@Length(max = 100,min = 2)
    private String name;


    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnoreProperties(value = {"country"})
    private State state;

    public City()
    {
    }

    public City(String name, State state)
    {
        this.name = name;
        this.state = state;
    }
}
