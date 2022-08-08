package com.es.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

import com.es.document.Student;
import com.es.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;

	public Iterable<Student> getAllStudent() {

		return repository.findAll();
	}

	public Student saveStudent(Student student) {

		return repository.save(student);
	}

	public Student getStudentById(Long id) {

		return repository.findById(id).get();
	}

	public Student updateStudent(Student student) {

		return repository.save(student);
	}

	public void deleteStudentById(Long id) {

		repository.deleteById(id);

	}
}
