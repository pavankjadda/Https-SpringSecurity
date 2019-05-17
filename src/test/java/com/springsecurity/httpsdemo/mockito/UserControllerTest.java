package com.springsecurity.httpsdemo.mockito;

import com.springsecurity.httpsdemo.model.UserProfile;
import com.springsecurity.httpsdemo.repo.AddressRepository;
import com.springsecurity.httpsdemo.repo.UserProfileRepository;
import com.springsecurity.httpsdemo.repo.UserRepository;
import com.springsecurity.httpsdemo.model.Address;
import com.springsecurity.httpsdemo.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles(value = "integrationtest")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserControllerTest
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private AddressRepository addressRepository;

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private Address address;

    @Before
    public void setUp()
    {
        this.username="admin";
        this.password="admin";
        this.email="hoe@gmc.com";
        this.firstName="John";
        this.lastName="Doe";
        this.address=findAddressById(21L);
    }

    private Address findAddressById(Long id)
    {
        return addressRepository.findById(id).orElse(null);
    }

    @Test
    public void createUser()
    {
        User user=new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        UserProfile userProfile=createUserProfile();
        user.setUserProfile(userProfile);
        user=userRepository.saveAndFlush(user);

        userProfile.setUser(user);
        userProfileRepository.saveAndFlush(userProfile);
    }

    private UserProfile createUserProfile()
    {
        UserProfile userProfile=new UserProfile();
        userProfile.setEmail(this.email);
        userProfile.setFirstName(this.firstName);
        userProfile.setLastName(this.lastName);
        ArrayList<Address> addressArrayList=new ArrayList<>();
        addressArrayList.add(this.address);
        userProfile.setAddresses(addressArrayList);
        return userProfileRepository.saveAndFlush(userProfile);
    }
}
