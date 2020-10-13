package com.example.restfulwebservice.service;

import com.example.restfulwebservice.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();
    private static int userCount = 3;

    static {
        userList.add(new User(1, "sskim", new Date()));
        userList.add(new User(2, "David", new Date()));
        userList.add(new User(3, "Raina", new Date()));
    }

    @Override
    public void save() {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findOne(int id) {
        return null;
    }
}
