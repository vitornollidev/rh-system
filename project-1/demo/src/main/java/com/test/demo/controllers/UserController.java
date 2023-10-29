package com.test.demo.controllers;

import com.test.demo.dtos.UserDTO;
import com.test.demo.dtos.UserInsertDTO;
import com.test.demo.entities.User;
import com.test.demo.repositories.DepartmentRepository;
import com.test.demo.repositories.UserRepository;
import com.test.demo.services.exceptionsTypes.ResourcesNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> result = repository.findAll();
        List<UserDTO> dtoList = result.stream().map(entity -> new UserDTO(entity.getId(), entity.getName(),
                entity.getEmail(), entity.getRole(), entity.getDepartment())).toList();
        return ResponseEntity.ok().body(dtoList);
    }

    @Transactional(readOnly = true)
    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id){
        Optional<User> entity = repository.findById(id);
        User user = entity.orElseThrow(()-> new ResourcesNotFound("Id " + id + " not found"));
        return user;
    }
    @Transactional
    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserInsertDTO dto){
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setRole(dto.role());
        user.setDepartment(dto.department());

        user = repository.save(user);

        return ResponseEntity.ok().body(new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getDepartment()));
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
    @GetMapping(value = "/name={name}")
    public ResponseEntity<List<UserDTO>> findUserByName(@PathVariable String name) {
        List<User> users = repository.findUserByName(name);

        if (users.isEmpty()) {
            throw new ResourcesNotFound("Name: " + name + " not found");
        }

        List<UserDTO> userDTOs = users.stream()
                .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getDepartment()))
                .toList();

        return ResponseEntity.ok().body(userDTOs);
    }


}
