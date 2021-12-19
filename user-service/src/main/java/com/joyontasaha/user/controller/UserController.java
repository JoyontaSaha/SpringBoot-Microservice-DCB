package com.joyontasaha.user.controller;

import com.joyontasaha.user.ValueObject.ResponseTemplateVO;
import com.joyontasaha.user.entity.User;
import com.joyontasaha.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable("id") Long userId) {
        log.info("Inside getUser of UserController");
        return userService.findUserById(userId);
    }

    @GetMapping("/getUserWithDepartment/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
