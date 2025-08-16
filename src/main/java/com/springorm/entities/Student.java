package com.springorm.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="student_name")
	private String name;
	
	@Column(name="student_age")
	private int age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	

	public  int getId() {
		return id;
	}

	public  void setId(int id) {
		this.id = id;
	}

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

	public  int getAge() {
		return age;
	}

	public  void setAge(int age) {
		this.age = age;
	}

	
}
