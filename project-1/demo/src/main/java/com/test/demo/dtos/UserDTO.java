package com.test.demo.dtos;

import com.test.demo.entities.Department;
import com.test.demo.entities.Role;

public record UserDTO (Long id, String name, String email, Role role, Department department){
}
