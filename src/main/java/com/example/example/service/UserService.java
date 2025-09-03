package com.example.example.service;

import com.example.example.dto.UserCreateDTO;
import com.example.example.dto.UserResponseDTO;
import com.example.example.exceptions.EmptyUsersException;
import com.example.example.exceptions.UserNotFoundException;
import com.example.example.exceptions.userAlreadyExists;
import com.example.example.mapper.userMapper;
import com.example.example.model.User;
import com.example.example.repo.UserRepo;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private userMapper mapper;

    public UserResponseDTO create(UserCreateDTO userCreateDTO) throws userAlreadyExists {
        if (userCreateDTO == null) {
            throw new IllegalArgumentException("User creation data cannot be null");
        }

        if (userRepo.findByEmail(userCreateDTO.getEmail()).isPresent()) {
            throw new userAlreadyExists("User with this email already exists");
        }

        String encryptedPassword = BCrypt.hashpw(userCreateDTO.getPassword(), BCrypt.gensalt());
        userCreateDTO.setPassword(encryptedPassword);

        User user1 = mapper.toEntity(userCreateDTO);
        userRepo.save(user1);
        return mapper.toDTO(user1);
    }

    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            throw new EmptyUsersException("No users found");
        }
        return users.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO getById(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return mapper.toDTO(user);
    }
}
