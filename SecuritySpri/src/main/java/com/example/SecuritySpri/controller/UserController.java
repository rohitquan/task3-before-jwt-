package com.example.SecuritySpri.controller;

import com.example.SecuritySpri.dto.UserDto;
import com.example.SecuritySpri.model.ModelUser;
import com.example.SecuritySpri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return "User created successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
        return userService.verify(userDto);
    }

    @GetMapping
    public List<ModelUser> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/updatePassword")
    public void updatePassword(@RequestBody UserDto userDto){
        userService.changePassword(userDto);
    }

}
