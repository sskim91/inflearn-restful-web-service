package com.example.restfulwebservice.controller;

import com.example.restfulwebservice.domain.User;
import com.example.restfulwebservice.exception.UserNotFoundException;
import com.example.restfulwebservice.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUserController {

    private final UserService service;

    //외부 생성자 주입
    public AdminUserController(UserService service) {
        this.service = service;
    }

    //전체 목록 가져오기
    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<User> usersAll = service.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "password");

        //필터를 추가할 때는 빈의 이름을 적어줘야 하는데 domain의 @JsonFilter에 지정한 이름이 id이다.
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(usersAll);
        mapping.setFilters(filters);

        return mapping;
    }

    //사용자 한명
    //GET /users/1 or /users/10 -> int형으로 보내도 String형으로 변환됨. but 이런 문자형태도 int 형으로 선언하면 자동으로 converting 된다.
    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable int id) {

        User user = service.findOne(id);
        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        //프로그램 내부에서 다양한 속성을 제어할 수 있다는 장점이 있다.
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "password", "ssn");

        //필터를 추가할 때는 빈의 이름을 적어줘야 하는데 domain의 @JsonFilter에 지정한 이름이 id이다.
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }
}
