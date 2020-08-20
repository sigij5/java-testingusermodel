package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.UserModelApplication;
import com.lambdaschool.usermodel.models.Role;
import com.lambdaschool.usermodel.models.User;
import com.lambdaschool.usermodel.models.UserRoles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserModelApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

//        List<User> myList = userService.findAll();
//        for (User u : myList){
//            System.out.println(u.getUserid() + " " + u.getUsername());
//        }
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findUserById() {
        assertEquals("cinnamon", userService.findUserById(7).getUsername());
    }

    @Test(expected = EntityNotFoundException.class)
    public void findRestaurantByIdNotFound(){
        assertEquals("Test Eagle Cafe", userService.findUserById(100).getUsername());
    }

    @Test
    public void findByNameContaining() {
        assertEquals(1, userService.findByNameContaining("cinn").size());
    }

    @Test
    public void findAll() {
        assertEquals(5, userService.findAll().size());
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByName() {
    }

    @Test
    public void saveadd() {
        User u2 = new User("Sigi", "password", "email");
        u2.setUserid(7);

        Role r1 = new Role("Admin");
        r1.setRoleid(1);
        u2.getRoles().add(new UserRoles(u2, r1));

        User addUser = userService.save(u2);
        assertNotNull(addUser);
        assertEquals("Sigi", addUser.getUsername());
    }

    @Test
    public void saveput() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteAll() {
    }
}