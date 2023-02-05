package com.gl.collegefest.service;

import java.util.List;

import com.gl.collegefest.model.Student;

public interface StudentService {
	public List<Student> getStudents();

	public Student save(Student student);

	public Student update(Student student);

	public void delete(Integer id);

	public Student findById(Integer id);
}
