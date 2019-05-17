package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUsername(String username);
}
