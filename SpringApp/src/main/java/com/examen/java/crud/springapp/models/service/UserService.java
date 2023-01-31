package com.examen.java.crud.springapp.models.service;

import com.examen.java.crud.springapp.models.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getById(Integer id);
    User createUser(User user);

    User updateUser(User user, Integer id);

    ResponseEntity<?> deleteUser(Integer id);
}
