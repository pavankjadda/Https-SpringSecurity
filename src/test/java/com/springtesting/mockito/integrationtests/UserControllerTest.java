package com.springtesting.mockito.integrationtests;

import com.springtesting.SpringtestingApplication;
import com.springtesting.model.User;
import com.springtesting.repo.UserRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringtestingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void createUser2() throws Exception
    {
        User user=new User("admin","AdminFirst","AdminLast","tets@hs.com","3130jdjjf","admin");
        mockMvc.perform(post("/users/create",user).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id",CoreMatchers.is(user.getId())));
    }

    @Test
    public void getUser() throws Exception
    {
        createUser();
        User user=new User("admin","AdminFirst","AdminLast","tets@hs.com","3130jdjjf","admin");
        mockMvc.perform(get("/users").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", CoreMatchers.is(user.getId())));
    }


    public void createUser()
    {
        User user=new User("admin","AdminFirst","AdminLast","tets@hs.com","3130jdjjf","admin");
        userRepository.save(user);
    }


}
