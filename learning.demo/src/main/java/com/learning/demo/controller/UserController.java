package com.learning.demo.controller;

import com.learning.demo.entities.User;
import com.learning.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/hello_world")
    public String helloWorld(){
        return webClientBuilder.build().get()
                    .uri("http://localhost:8082/hello")
                    .retrieve().bodyToMono(String.class).block()
                + " " +
                webClientBuilder.build().get()
                    .uri("http://localhost:8083/world")
                    .retrieve().bodyToMono(String.class).block();
    }
}
