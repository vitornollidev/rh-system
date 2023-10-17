package com.test.demo.controllers;

import com.test.demo.entities.User;
import com.test.demo.repositories.UserRepository;
import com.test.demo.services.exceptionsTypes.ResourcesNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll(){
        List<User> result = repository.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        Optional<User> entity = repository.findById(id);
        User user = entity.orElseThrow(()-> new ResourcesNotFound("Id " + id + " not found"));
        return user;
    }
    @PostMapping
    public User insert(@RequestBody User user){
        User result = repository.save(user);
        return result;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<User> entity = repository.findById(id);

        User user = entity.orElseThrow(()-> new ResourcesNotFound("Id " + id + " not found to delete!"));
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    }
//    @PutMapping(value = "/edit/{id}")
//    public Boolean edit(@RequestBody User user){
//        repository.updateUser(user.getDepartment().getId(), user.getName(), user.getEmail(), user.getId());
//        return true;
//    }

}
