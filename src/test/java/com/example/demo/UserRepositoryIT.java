package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRepositoryIT {
    @Autowired
    private UserRepository repository;

    @Test
    void whenSave_thenFindAll() {
        repository.save(new User("Alice"));
        assertThat(repository.findAll()).isNotEmpty();
    }
}