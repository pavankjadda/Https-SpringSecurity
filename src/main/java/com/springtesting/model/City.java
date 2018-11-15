package com.springtesting.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "city")
@Data
public class City
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(name = "name")
    @Length(max = 100,min = 2)
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    public City() { }

    public City(@Length(max = 100, min = 2) String name, State state)
    {
        this.name = name;
        this.state = state;
    }
}
