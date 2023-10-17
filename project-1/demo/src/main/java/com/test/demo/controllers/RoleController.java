package com.test.demo.controllers;

import com.test.demo.dtos.RoleDTO;
import com.test.demo.dtos.RoleInsertDTO;
import com.test.demo.entities.Role;
import com.test.demo.repositories.RoleRepository;
import com.test.demo.services.exceptionsTypes.ResourcesNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    private RoleRepository repository;

    @GetMapping
    public List<Role> getAllRoles(){
        List<Role> roleList = repository.findAll();
        return roleList;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id){
        Optional<Role> entity = repository.findById(id);
        Role role = entity.orElseThrow(()-> new ResourcesNotFound("Id " + id + "not found"));
        return ResponseEntity.ok().body(new RoleDTO(role.getId() , role.getName()));
    }
    @PostMapping
    public ResponseEntity<RoleDTO> insert(@RequestBody RoleInsertDTO dto){
        Role role = new Role();
        role.setName(dto.name());
        role = repository.save(role);

        return ResponseEntity.ok().body(new RoleDTO(role.getId(), role.getName()));
    }
}
