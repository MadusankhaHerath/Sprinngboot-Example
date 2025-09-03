package com.example.example.mapper;

import com.example.example.dto.UserCreateDTO;
import com.example.example.dto.UserResponseDTO;
import com.example.example.model.User;
import org.springframework.stereotype.Component;

@Component
public class userMapper {
    public User toEntity(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setName(userCreateDTO.getName());
        user.setEmail(userCreateDTO.getEmail());
        user.setPassword(userCreateDTO.getPassword());
        // map other fields as needed
        return user;
    }

    public UserResponseDTO toDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPassword(user.getPassword());
        return userResponseDTO;
    }

}
