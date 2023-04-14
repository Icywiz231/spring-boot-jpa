package com.webapp.SpringJPAApplication.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.SpringJPAApplication.course.Course;

public interface CourseSpringData extends JpaRepository<Course, Long>{
	
	List<Course> findByAuthor(String author);
	
	List<Course> findByName (String courseName);
}
