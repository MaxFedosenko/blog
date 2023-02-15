package com.kam.blog.controllers;

import com.kam.blog.entities.User;
import com.kam.blog.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }
    
    @GetMapping("/getbyid")
    public ResponseEntity<User> getById(@RequestParam Long id) {
        return ResponseEntity.ok().body(userService.getById(id));
    }
    
    @GetMapping("/getbyname")
    public ResponseEntity<User> getByName(@RequestParam String userName) {
        return ResponseEntity.ok().body(userService.getByName(userName));
    }
    
    @PostMapping("/create")
    public ResponseEntity<User> create(@Valid User user) {
        return ResponseEntity.ok().body(userService.create(user));
    }
    
    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestParam String newName, @RequestParam Long id){
        userService.update(newName, id);
        return ResponseEntity.ok().body(userService.getById(id));
    }
    
    @DeleteMapping()
    public void delete(@RequestParam Long id){
        userService.delete(id);
    }

}
