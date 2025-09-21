package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }
    @GetMapping
    public List<User> list() { return service.list(); }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User u) {
        User saved = service.create(u);
        return ResponseEntity.created(URI.create("/api/users/" + saved.getId())).body(saved);
    }
}