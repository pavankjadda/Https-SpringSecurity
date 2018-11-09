package com.springtesting.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
@Table(name = "user")
public class User
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;


    @NotNull(message = "Address must not be null")
    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserProfile userProfile;


    public User()
    {

    }

    public User(String username, @NotNull(message = "Address must not be null") @NotEmpty String password, UserProfile userProfile)
    {
        this.username = username;
        this.password = password;
        this.userProfile = userProfile;
    }
}
