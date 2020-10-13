package com.example.restfulwebservice.controller;

import com.example.restfulwebservice.domain.User;
import com.example.restfulwebservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    //외부 생성자 주입
    public UserController(UserService service) {
        this.service = service;
    }

    //전체 목록 가져오기
    @GetMapping("/users")
    public List<User> retrieveAllusers() {
        return service.findAll();
    }

    //사용자 한명
    //GET /users/1 or /users/10 -> int형으로 보내도 String형으로 변환됨. but 이런 문자형태도 int 형으로 선언하면 자동으로 converting 된다.
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {    //
        return service.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
