package com.test.demo.repositories;

import com.test.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {


//    @Transactional
//    @Modifying
//    @Query("UPDATE User u SET u.department.id = :departmentId, u.name = :name, u.email = :email WHERE u.id = :userId")
//    void updateUser(@Param("departmentId") Long departmentId, @Param("name") String name, @Param("email") String email, @Param("userId") Long userId);

    @Query("SELECT u FROM User u WHERE u.name LIKE :name%")
    List<User> findUserByName(@Param("name") String name);
}
