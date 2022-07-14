package com.gl.student.StudentEvent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Preethi Student class to create student_event table in DB
 *
 */
@Entity
@Table(name = "student_event")
@Data
@NoArgsConstructor
public class Student {

	@Id
	@Column(name = "studentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "courseName")
	private String courseName;

	@Column(name = "country")
	private String country;

	public Student(String firstName, String lastName, String courseName, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.courseName = courseName;
		this.country = country;
	}

}
