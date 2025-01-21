package com.apirest.APIRest.presentation.controllers;

import com.apirest.APIRest.service.IUserService;
import com.apirest.APIRest.presentation.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    //Find all users
    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> findAll() {
        //ResponseEntity envuelve a List u objeto y que permite manejar respuestas HTTP.
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    //Find user by id
    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.findById(id), HttpStatus.OK);
    }

    //Save user
    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(this.userService.save(userDTO), HttpStatus.CREATED);
    }

    //Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.update(userDTO, id), HttpStatus.OK);
    }

    //Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(this.userService.delete(id), HttpStatus.NO_CONTENT);
    }
}