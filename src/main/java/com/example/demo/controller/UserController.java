package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @GetMapping("/user")
    @ResponseBody
        public List<User> findInPage(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize) {
        // startPage(pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.findAll();
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable long userId) {
        return userMapper.findById(userId);
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
        userMapper.insertUser(user);
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@RequestBody User user,@PathVariable long userId) {
        userMapper.updateUser(userId, user.getName());
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable long userId) {
        userMapper.deleteUser(userId);
    }
}