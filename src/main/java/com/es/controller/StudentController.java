package com.es.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.document.Student;
import com.es.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	// handler method for getAllStudent
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		model.addAttribute("students", service.getAllStudent());
		return "student";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	// Handler method to save Student
	@PostMapping("/students")
	public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result);
			return "create_student";
		}
		service.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable long id, Model model) {
		model.addAttribute("student", service.getStudentById(id));

		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
		// get old student object
		Student existingStudent = service.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setName(student.getName());
		existingStudent.setCity(student.getCity());
		existingStudent.setEmail(student.getEmail());

		// Save Updated Student Object
		service.updateStudent(existingStudent);

		return "redirect:/students";
	}

	@GetMapping(path = "/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);

		return "redirect:/students";
	}
}
