package com.pj.springsecurity.https.repo;

import com.pj.springsecurity.https.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long>
{
}
