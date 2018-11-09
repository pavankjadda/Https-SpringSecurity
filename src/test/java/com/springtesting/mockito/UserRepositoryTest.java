package com.springtesting.mockito;

import com.springtesting.model.User;
import com.springtesting.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest
{
    @Autowired
    UserRepository userRepository;

    @Test
    public void updateUser()
    {
        String username="admin";
        User user=userRepository.findByUsername(username);
        user=userRepository.findById((long) 1001).get();
        user.setPassword("admin");
        userRepository.save(user);
    }

    @Test
    public void getAllUsers()
    {
        List<User> userList = userRepository.findAll();
        for (User user:userList)
        {
            System.out.println("user => "+user.toString());
        }
    }

    @Test
    public void createUser()
    {
        User user=new User("admin","Admin","AdminLast","test@hm.com","3103 jfjfj","admin");
        user=userRepository.save(user);

        System.out.println("user=> "+user.toString());
    }
}
