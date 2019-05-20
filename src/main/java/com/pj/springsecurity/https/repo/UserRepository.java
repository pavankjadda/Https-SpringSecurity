package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findByUsername(String username);

}
