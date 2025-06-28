package com.example.example.controller;


import com.example.example.dto.UserDTO;
import com.example.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService UserService;

    @GetMapping("/getusers")
    public List<UserDTO> getUsers() {
        return UserService.getAllUsers();
    }

    @PostMapping("/adduser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return UserService.saveUser(userDTO);
    }


}
