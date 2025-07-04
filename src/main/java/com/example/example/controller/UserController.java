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
    @Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<UserDTO> getUsers() {
        return UserService.getAllUsers();
    }

    @PostMapping("/adduser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return UserService.saveUser(userDTO);
    }

    @PutMapping("/updateuser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return UserService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteuser/{userid}")
    public String deleteUser(@PathVariable Integer userid){
        return UserService.deleteUser(userid);
    }


}
