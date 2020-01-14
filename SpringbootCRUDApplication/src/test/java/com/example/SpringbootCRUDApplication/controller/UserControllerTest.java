package com.example.SpringbootCRUDApplication.controller;

import com.example.SpringbootCRUDApplication.entity.User;
import com.example.SpringbootCRUDApplication.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById() {
        User u = new User();
        u.setId(1l);
        when(userRepository.getUser("1")).thenReturn(u);
        User user = userController.getUser(String.valueOf(1L));
        verify(userRepository).getUser("1");
        assertThat(user.getId(), is(1L));
    }

    @Test
    public void testGetAllUsers() {
        List<User> list = new ArrayList<>();

        User u = new User();
        u.setId(1l);
        User u1 = new User();
        u1.setId(2l);
        list.add(u);
        list.add(u1);

        when(userRepository.getAllUsers()).thenReturn(list);
        List<User> user = userController.getAllUsers();
        verify(userRepository).getAllUsers();
        assertThat(user.size(), is(2));
    }

    @Test
    public void testAddNewUser() {
        User u1 = new User();
        u1.setId(2l);
        u1.setFirstName("satya");
        u1.setLastName("maurya");
        u1.setEmail("parkash.satya87@gmail.com");
        u1.setPhoneNo("1233");
        u1.setAddress("fsdfds");

        userRepository.addUser(u1);
    }
}