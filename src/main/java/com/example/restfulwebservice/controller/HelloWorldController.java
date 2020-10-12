package com.example.restfulwebservice.controller;

import com.example.restfulwebservice.domain.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    //GET
    // /hello-world (endpoint) 사용자에 의해서 호출되는 uri를 endpoint라고 한다.
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//    @GetMapping(path = "/hello-world")  //이것도 가능
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
