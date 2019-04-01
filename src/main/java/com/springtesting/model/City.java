package com.springtesting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
public class City
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnore
    private State state;

    public City() { }

    public City( String name, State state)
    {
        this.name = name;
        this.state = state;
    }
}
