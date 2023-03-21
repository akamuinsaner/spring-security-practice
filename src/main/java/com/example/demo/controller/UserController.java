package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Long processUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.save(user);
    }

    @GetMapping("/userGet")
    public UserDetails findByUserName(@RequestParam("username") String username) {
        return userService.loadUserByUsername(username);
    }

    @PostMapping("/addRoleToUser")
    public Long addRoleToUser(@RequestBody Map<String, Object> param) {
        Long userId = ((Number) param.get("userId")).longValue();
        String name = ((String) param.get("name"));
        Role role = new Role();
        role.setName(name);
        return userService.addRoleToUser(userId, role);
    }
}
