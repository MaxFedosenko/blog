package com.kam.blog.services.impl;

import com.kam.blog.entities.User;
import com.kam.blog.exceptions.ResourceNotFoundException;
import com.kam.blog.repositories.UserRepository;
import com.kam.blog.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User getByName(String userName) {
        return userRepository.getByUserName(userName);
    }
    
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
    
    @Override
    public User getById (Long id){
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    
    @Override
    public void update(String newName, Long id) {
        User user = getById(id);
        userRepository.update(newName, user.getId());
    }
    
    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
