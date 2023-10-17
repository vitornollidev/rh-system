package com.test.demo.controllers;

import com.test.demo.dtos.DepartmentDTO;
import com.test.demo.dtos.DepartmentInsertDTO;
import com.test.demo.entities.Department;
import com.test.demo.repositories.DepartmentRepository;
import com.test.demo.services.exceptionsTypes.ResourcesNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    @GetMapping
    public List<Department> findAll(){
        List<Department> result = repository.findAll();
        return result;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> findDepartmentById(@PathVariable Long id){
        Optional<Department> entity = repository.findById(id);
        Department department = entity.orElseThrow(()-> new ResourcesNotFound("Id " + id + " not found!"));

        return ResponseEntity.ok().body(new DepartmentDTO(department.getId(), department.getName()));
    }
    @PostMapping
    public ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentInsertDTO dto){
        Department department = new Department();
        department.setName(dto.name());
        department = repository.save(department);

        return ResponseEntity.ok().body(new DepartmentDTO(department.getId(), department.getName()));
    }
}
