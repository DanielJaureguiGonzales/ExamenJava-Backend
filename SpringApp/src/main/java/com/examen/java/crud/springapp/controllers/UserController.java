package com.examen.java.crud.springapp.controllers;

import com.examen.java.crud.springapp.models.entity.User;
import com.examen.java.crud.springapp.models.repository.UserRepository;
import com.examen.java.crud.springapp.models.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/list/{userId}")
    public User getUserById(@PathVariable(name = "userId") Integer id){
        return userService.getById(id);
    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable(name = "userId") Integer id){
        return userService.updateUser(user,id);
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "userId") Integer id){
        return userService.deleteUser(id);
    }

}
