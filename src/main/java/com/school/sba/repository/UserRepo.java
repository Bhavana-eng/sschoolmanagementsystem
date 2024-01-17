package com.school.sba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.school.sba.entity.User;
import com.school.sba.enums.UserRole;



public interface UserRepo extends JpaRepository<User, Integer>{

	boolean existsByUserRole(UserRole admin);

}
