package com.pj.springsecurity.https.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Data
@Table(name = "`user`")
public class User implements Serializable
{

    private static final long serialVersionUID = -6953452565398553524L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @Column(name = "account_non_locked")
    private Boolean accountNonLocked;

    @Column(name = "account_non_expired")
    private Boolean accountNonExpired;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user",optional = false)
    private UserProfile userProfile;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles=new ArrayList<>();

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

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", active=" + active +
                ", password='" + password + '\'' +
                '}';
    }
}
