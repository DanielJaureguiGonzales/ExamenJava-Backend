package com.examen.java.crud.springapp.controllers;

import com.examen.java.crud.springapp.exceptions.CrudException;
import com.examen.java.crud.springapp.models.entity.User;
import com.examen.java.crud.springapp.models.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getAllUsers() throws CrudException {
        return userService.getAllUsers();
    }

    @GetMapping("/list/{userId}")
    public User getUserById(@PathVariable(name = "userId") Integer id) throws CrudException {
        return userService.getById(id);
    }

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user,@RequestParam MultipartFile archivo) throws IOException, CrudException {
        return userService.createUser(user,archivo);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable(name = "userId") Integer id) throws CrudException {
        return userService.updateUser(user,id);
    }


    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "userId") Integer id) throws CrudException {
        return userService.deleteUser(id);
    }

}
