package com.webapp.SpringJPAApplication.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.webapp.SpringJPAApplication.course.springdatajpa.CourseSpringData;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringData springDataJPARepo;
	
	@Override
	public void run(String... args) throws Exception {
		springDataJPARepo.save(new Course (1, "AWS", "Amazon"));
		springDataJPARepo.save(new Course (2, "Azure", "Amazon"));
		springDataJPARepo.save(new Course (3, "GCP", "Google"));
		
//		springDataJPARepo.deleteById(2l);

		System.out.println(springDataJPARepo.findById(1l));
		System.out.println(springDataJPARepo.findById(3l));
		
		System.out.println(springDataJPARepo.findByName("AWS"));
	}
}