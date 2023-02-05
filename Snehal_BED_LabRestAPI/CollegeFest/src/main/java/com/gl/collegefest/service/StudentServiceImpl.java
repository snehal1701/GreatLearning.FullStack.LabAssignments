package com.gl.collegefest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.collegefest.dao.StudentRepository;
import com.gl.collegefest.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepo;

	@Override
	public List<Student> getStudents() {

		return studentRepo.findAll();
	}

	@Override
	public Student save(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student update(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student findById(Integer id) {

		return studentRepo.getReferenceById(id);
	}

	@Override
	public void delete(Integer id) {

		Student st = this.findById(id);
		studentRepo.delete(st);

	}

}
