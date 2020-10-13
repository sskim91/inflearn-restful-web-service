package com.example.restfulwebservice.service;

import com.example.restfulwebservice.domain.User;

import java.util.List;

public interface UserService {

    public void save();

    public List<User> findAll();

    public User findOne(int id);
}
