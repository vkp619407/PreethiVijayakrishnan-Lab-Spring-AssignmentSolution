package com.gl.student.StudentEvent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.student.StudentEvent.model.Student;
import com.gl.student.StudentEvent.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public void save(Student student) {
		studentRepo.save(student);

	}

	@Override
	public void deleteById(int id) {
		studentRepo.deleteById(id);
	}

}
