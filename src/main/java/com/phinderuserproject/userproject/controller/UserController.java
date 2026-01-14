package com.phinderuserproject.userproject.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phinderuserproject.userproject.dto.UserDTO;
import com.phinderuserproject.userproject.service.IUserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RequiredArgsConstructor
@RestController
@RequestMapping("/WSCentralesMock/api/v1/usuarios")
public class UserController {
    
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers (){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable Integer id){
        return ResponseEntity.ok(userService.findUserByID(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO dto){
        UserDTO created = userService.createUser(dto);
        return ResponseEntity.created(URI.create("/api/v1/usuarios" + created.getName())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser (@PathVariable Integer id, @RequestBody UserDTO dto){
        return ResponseEntity.ok(userService.updateUser(id, dto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }



    

}
