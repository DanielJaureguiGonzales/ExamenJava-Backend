package com.examen.java.crud.springapp.models.service;

import com.examen.java.crud.springapp.exceptions.CrudException;
import com.examen.java.crud.springapp.models.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getAllUsers()  throws CrudException;
    User getById(Integer id) throws CrudException;
    User createUser(User user, MultipartFile archivo) throws CrudException, IOException;

    User updateUser(User user, Integer id) throws CrudException;

    ResponseEntity<?> deleteUser(Integer id) throws CrudException;
}
