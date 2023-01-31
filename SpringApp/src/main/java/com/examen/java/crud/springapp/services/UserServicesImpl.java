package com.examen.java.crud.springapp.services;

import com.examen.java.crud.springapp.exceptions.CrudException;
import com.examen.java.crud.springapp.exceptions.InternalServerError;
import com.examen.java.crud.springapp.exceptions.ResourceNotFoundException;
import com.examen.java.crud.springapp.models.entity.User;
import com.examen.java.crud.springapp.models.repository.UserRepository;
import com.examen.java.crud.springapp.models.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserServicesImpl implements UserService {

    private final Logger log= LoggerFactory.getLogger(UserServicesImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() throws CrudException {
        List<User> usersFound;
       try {
           usersFound = userRepository.findAll();
       }catch (Exception e){
           log.error(e.getMessage());
           throw new InternalServerError("Lista de categorias no encontrada");
       }
       return usersFound;
    }

    @Override
    public User getById(Integer id) throws CrudException{


        return userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("No se pudo encontrar al usuario"));
    }

    @Override
    public User createUser(User user , MultipartFile archivo) throws CrudException, IOException {

       User createUser = user;
        System.out.println(createUser);

        try {
            createUser.setTx_avatar(archivo.getBytes());

        }catch (Exception e){
            throw new InternalServerError("No se pudo crear un usuario");
        }

        return userRepository.save(createUser);
    }

    @Override
    public User updateUser(User user, Integer id) throws CrudException {

      return userRepository.findById(id).map( u -> {
          u.setTx_uid(user.getTx_uid());
          u.setTx_user(user.getTx_user());
          u.setTx_email(user.getTx_email());
          u.setTx_pass(user.getTx_pass());
          u.setTx_rol(user.getTx_rol());
          u.setTx_fullname(user.getTx_fullname());
          u.setTx_avatar(user.getTx_avatar());
          log.info("Actualizando Usuario");
          return userRepository.save(u);
      }).orElseThrow(()-> new ResourceNotFoundException("No se pudo encontrar el usuario"));

    }

    @Override
    public ResponseEntity<?> deleteUser(Integer id) throws CrudException {
        User user = userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("No se pudo encontrar el usuario"));
        try {
            userRepository.delete(user);
        }catch (Exception e){
            log.error("No se pudo eliminar el usuario");
        }
        return ResponseEntity.ok().build();
    }
}
