package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

//	Save Student
	@Transactional
	public int insert(Student student) {
//		insert
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

//	get the single row
	public Student getStudent(int studentid) {
		return this.hibernateTemplate.get(Student.class, studentid);

	}
	
//	get the all rows
	public List<Student> getAllStudent() {
		return this.hibernateTemplate.loadAll(Student.class);
	}
	
//	deleting rows
	@Transactional
	public void deleteStudent(int studentid) {
		Student student = this.hibernateTemplate.get(Student.class,studentid);
		this.hibernateTemplate.delete(student);
	}
	
//	update rows
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
