package com.thegypsycoder.demo.controller;

import com.thegypsycoder.demo.domain.User;
import com.thegypsycoder.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")

    public Iterable<User> List(){
        return userService.list();
    }

}
