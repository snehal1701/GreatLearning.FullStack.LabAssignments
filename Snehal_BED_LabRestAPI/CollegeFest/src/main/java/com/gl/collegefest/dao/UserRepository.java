package com.gl.collegefest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.collegefest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
