package com.webapp.SpringJPAApplication.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webapp.SpringJPAApplication.course.Course;

@Repository
public class JDBCRepo {

	@Autowired
	private	JdbcTemplate springJdbcTemplate;
	private static String INSERT_QUERY = 
			"""  
					insert into course values (?,?,?);
					""";

	private static String DELETE_QUERY = 
			"""  
					delete from course where id = ?
					""";

	private static String SELECT_QUERY = 
			"""  
					select * from course where id = ?
					""";


	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById (long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById (long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
