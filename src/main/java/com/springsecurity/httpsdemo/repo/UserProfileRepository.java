package com.springsecurity.httpsdemo.repo;

import com.springsecurity.httpsdemo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long>
{
}
