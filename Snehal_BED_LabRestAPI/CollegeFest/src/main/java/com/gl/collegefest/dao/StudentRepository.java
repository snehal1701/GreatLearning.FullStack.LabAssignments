package com.gl.collegefest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.collegefest.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
