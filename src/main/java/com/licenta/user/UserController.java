package com.licenta.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAll() {
       return userRepository.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        Optional<User> findUser = userRepository.findById(id);
        User user;
        try {
            user = findUser.get();
            return user;
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
}
