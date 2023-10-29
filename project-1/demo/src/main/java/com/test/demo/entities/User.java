package com.test.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public User(){}

    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public Role getRole(){
        return this.role;
    }
    public void setRole(Role role){
        this.role = role;
    }

    public Department getDepartment(){
        return this.department;
    }
    public void setDepartment(Department department){
        this.department = department;
    }
}
