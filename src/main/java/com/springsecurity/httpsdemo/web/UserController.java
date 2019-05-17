package com.springsecurity.httpsdemo.web;

import com.springsecurity.httpsdemo.model.User;
import com.springsecurity.httpsdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController
{
    private final UserRepository userRepository;


    @Autowired
    public UserController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    //Users Controller Methods

    @PostMapping(value = "/users/create")
    public User createNewUser(@RequestBody User user)
    {
        return userRepository.saveAndFlush(user);
    }

    @GetMapping(value = "/users")
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public Optional<User> findById(@PathVariable Long id)
    {
        return userRepository.findById(id);
    }


}
