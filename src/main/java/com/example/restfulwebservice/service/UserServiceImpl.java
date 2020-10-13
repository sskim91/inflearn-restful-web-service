package com.example.restfulwebservice.service;

import com.example.restfulwebservice.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();
    private static int userCount = 3;

    static {
        userList.add(new User(1, "sskim", new Date()));
        userList.add(new User(2, "Alice", new Date()));
        userList.add(new User(3, "Elena", new Date()));
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        userList.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public User findOne(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
