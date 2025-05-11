package com.rentacarapp.rentacarsystem.service.impl;

import com.rentacarapp.rentacarsystem.model.User;
import com.rentacarapp.rentacarsystem.repository.UserRepository;
import com.rentacarapp.rentacarsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists!");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setUsername(user.getUsername());
            existing.setPasswordHash(user.getPasswordHash());
            existing.setEmail(user.getEmail());
            existing.setPhone(user.getPhone());
            existing.setRoleId(user.getRoleId());
            return userRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}