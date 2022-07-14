package com.gl.student.StudentEvent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.student.StudentEvent.model.Student;
import com.gl.student.StudentEvent.service.StudentService;

/**
 * @author Preethi ,Student Controller class
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String listStudents(Model model) {
		model.addAttribute("studentList", studentService.findAll());
		return "student-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("mode", "Add");
		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam("studentId") int studentId) {
		model.addAttribute("student", studentService.findById(studentId));
		model.addAttribute("mode", "Update");
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") int studentId, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("courseName") String courseName,
			@RequestParam("country") String country) {
		System.out.println("Inside saveStudent");
		Student student = null;
		if (studentId == 0) {
			student = new Student(firstName, lastName, courseName, country);

		} else {
			student = studentService.findById(studentId);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourseName(courseName);
			student.setCountry(country);
		}
		studentService.save(student);
		return "redirect:/student/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int studentId) {
		studentService.deleteById(studentId);
		return "redirect:/student/list";
	}

	@RequestMapping("/403")
	public String showErrorPage() {
		return "403";
	}

}
