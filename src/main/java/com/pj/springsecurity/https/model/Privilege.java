package com.pj.springsecurity.https.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(name = "privilege")
public class Privilege implements Serializable
{
    private static final long serialVersionUID = 9045371015918530740L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    @JsonIgnore
    private Collection<Role> roles;

    public Privilege()
    {
    }

    public Privilege(String name)
    {
        this.name = name;
    }


    public Privilege(String name, Collection<Role> roles)
    {
        this.name = name;
        this.roles = roles;
    }

    @Override
    public String toString()
    {
        return "Privilege{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
