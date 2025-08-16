package com.springorm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springorm.entities.Student;


public class StudentDao {
	
	
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int insert(Student student) {
		Integer i =  (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	@Transactional
	public void update(Student student) {
		this.hibernateTemplate.update(student);
	}
	
	@Transactional
	public void delete(Student student) {
		this.hibernateTemplate.delete(student);
	}
	
	public Student getStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class , id);
		return student;
	}
	
	public List<Student> getStudents(){
		List<Student> all = this.hibernateTemplate.loadAll(Student.class);
		return all;
	}

	public final HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public final void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
