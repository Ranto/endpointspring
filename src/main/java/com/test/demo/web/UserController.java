package com.test.demo.web;

import com.test.demo.entity.User;
import com.test.demo.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> all = userRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
