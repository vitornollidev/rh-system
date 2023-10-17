package com.test.demo.dtos;

import com.test.demo.entities.Department;
import com.test.demo.entities.Role;

public record UserInsertDTO (String name, String email, Role role, Department department){

}
