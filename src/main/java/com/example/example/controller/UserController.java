package com.example.example.controller;


import com.example.example.dto.UserCreateDTO;
import com.example.example.dto.UserResponseDTO;
import com.example.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example.service.UserService;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserCreateDTO userCreateDTO) {
        UserResponseDTO response = userService.create(userCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable int id) {
        UserResponseDTO response = userService.getById(id);
        return ResponseEntity.ok(response);
    }
}