package com.java38.spring_framework.lectures.restapi.service;

import com.java38.spring_framework.lectures.restapi.repository.UserRepository;
import com.java38.spring_framework.lectures.restapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(String name, String surname, String username,
                     String password, String email) {
        User newUser = new User(name, surname, username, password, email);
        return userRepository.save(newUser);
    }

    public User updateUser(User user) {
        Optional<User> updatedUser = userRepository.findById(user.getId());
        if (updatedUser.isEmpty()) {
            return null;
        }

        User newUser = updatedUser.get();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());

        return userRepository.save(newUser);
    }

    public boolean deleteUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.deleteById(user.getId());
                    return true;
                })
                .orElse(false);
    }
}
