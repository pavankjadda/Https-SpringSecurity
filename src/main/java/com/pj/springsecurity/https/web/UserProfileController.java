package com.pj.springsecurity.https.web;

import com.pj.springsecurity.https.model.UserProfile;
import com.pj.springsecurity.https.repo.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserProfileController
{
	private UserProfileRepository userProfileRepository;

	@Autowired
	public UserProfileController(UserProfileRepository userProfileRepository)
	{
		this.userProfileRepository = userProfileRepository;
	}

	@PostMapping(value = "/userprofile/create")
	public UserProfile createNewUserProfile(@RequestBody UserProfile UserProfile)
	{
		return userProfileRepository.saveAndFlush(UserProfile);
	}

	@GetMapping(value = "/userprofiles")
	public List<UserProfile> findAll()
	{
		return userProfileRepository.findAll();
	}

	@GetMapping(value = "/userprofile/{id}")
	public Optional<UserProfile> findById(@PathVariable Long id)
	{
		return userProfileRepository.findById(id);
	}

}
