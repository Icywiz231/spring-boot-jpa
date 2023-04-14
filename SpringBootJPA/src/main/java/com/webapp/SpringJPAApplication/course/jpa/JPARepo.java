package com.webapp.SpringJPAApplication.course.jpa;

import org.springframework.stereotype.Repository;

import com.webapp.SpringJPAApplication.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class JPARepo {
	
	@PersistenceContext // can also use @Autowired
	private EntityManager entityManager;
	
	public void insert (Course course) {
		entityManager.merge(course);
	}
	
	public Course findById (long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById (long id) {
		entityManager.remove(entityManager.find(Course.class, id));
	}
	
}
