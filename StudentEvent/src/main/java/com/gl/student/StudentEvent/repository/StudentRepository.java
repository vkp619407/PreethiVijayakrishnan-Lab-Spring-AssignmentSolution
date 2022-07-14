package com.gl.student.StudentEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.student.StudentEvent.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
