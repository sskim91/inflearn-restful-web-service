package com.example.restfulwebservice.service;

import com.example.restfulwebservice.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static List<User> userList = new ArrayList<>();
    private static int userCount = 3;

    static {
        userList.add(new User(1, "sskim", new Date(), "pass1", "701010-1111111"));
        userList.add(new User(2, "Alice", new Date(), "pass2", "801010-1111111"));
        userList.add(new User(3, "Elena", new Date(), "pass3", "901010-1111111"));
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

    @Override
    public User deleteById(int id) {
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }

    @Override
    public User updateById(int id, User user) {
        for (User updateUser : userList) {
            if (updateUser.getId() == id) {
                userList.get(id-1).setName(user.getName());
                userList.get(id-1).setJoinDate(user.getJoinDate());
                return user;
            }
        }
        return null;
    }
}
