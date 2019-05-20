package com.pj.springsecurity.https.dto;

import com.pj.springsecurity.https.model.Role;
import com.pj.springsecurity.https.model.UserProfile;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDto
{
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String token;

    private Collection<Role> roles;

    private UserProfile userProfile;

}
