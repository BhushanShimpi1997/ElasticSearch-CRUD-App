package com.es.document;

import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "universitystudent")
public class Student {

	@Id
	@Field(type = FieldType.Keyword)
	private long id;
	@Field(type = FieldType.Text)
	private String name;
	@Field(type = FieldType.Text)
	private String city;
	@Field(type = FieldType.Text)
	@Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",message="Invalid Email !!")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Student(String name, String city, String email) {
		super();
		this.name = name;
		this.city = city;
		this.email = email;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
