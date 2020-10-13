package com.example.restfulwebservice.service;

import com.example.restfulwebservice.domain.User;

import java.util.List;

public interface UserService {

    public User save(User user);

    public List<User> findAll();

    public User findOne(int id);
}
