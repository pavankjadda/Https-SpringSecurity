package com.pj.springsecurity.https.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "user")
public class User
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column
    private boolean active;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "user_profile_id")
    @JsonManagedReference
    private UserProfile userProfile;


    public User()
    {

    }

    public User(String username, String password, Boolean active, UserProfile userProfile)
    {
        this.username = username;
        this.password = password;
        this.active = active;
        this.userProfile = userProfile;
    }
}
