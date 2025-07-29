package com.test.learningapis.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.learningapis.exception.ResourceNotFoundException;
import com.test.learningapis.model.User;
import com.test.learningapis.repository.UserRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value="id")Long userId) throws ResourceNotFoundException{
        User user= userRepository
                        .findById(userId)
                        .orElseThrow(()->new ResourceNotFoundException("User Not Found for UserId: "+userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value="id") Long userId,@RequestBody User userDetails) throws ResourceNotFoundException{
        User user=userRepository.findById(userId)
                                .orElseThrow(()->new ResourceNotFoundException("User Not Found for UserId: "+userId));
        user.setEmail(userDetails.getEmail());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setUpdatedAt(new Date());
        final User updatedUser=userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value="id")Long userId) throws Exception{
        User user=userRepository.findById(userId)
                                .orElseThrow(()->new ResourceNotFoundException("User Not Found for UserId: "+userId));
        userRepository.delete(user);
        return ResponseEntity.ok().body("Deleted");
    }
    
    
}
