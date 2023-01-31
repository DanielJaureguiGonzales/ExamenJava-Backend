package com.examen.java.crud.springapp.services;

import com.examen.java.crud.springapp.exceptions.ResourceNotFoundException;
import com.examen.java.crud.springapp.models.entity.User;
import com.examen.java.crud.springapp.models.repository.UserRepository;
import com.examen.java.crud.springapp.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User","Id",id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Integer id) {
        return userRepository.findById(id).map( updateUser-> {
            updateUser.setTx_uid(user.getTx_uid());
            updateUser.setTx_user(user.getTx_user());
            updateUser.setTx_email(user.getTx_email());
            updateUser.setTx_pass(user.getTx_pass());
            updateUser.setTx_rol(user.getTx_rol());
            updateUser.setTx_fullname(user.getTx_fullname());
            updateUser.setTx_avatar(user.getTx_avatar());
            return userRepository.save(updateUser);
        } ).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
    }

    @Override
    public ResponseEntity<?> deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User","Id",id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
