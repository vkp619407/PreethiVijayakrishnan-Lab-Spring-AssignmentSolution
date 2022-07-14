package com.gl.student.StudentEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.student.StudentEvent.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String username);

}
