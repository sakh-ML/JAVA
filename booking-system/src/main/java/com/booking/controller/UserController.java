package com.booking.controller;

import com.booking.model.User;
import com.booking.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    final private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user,@PathVariable long id){
        return userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
    }

}
