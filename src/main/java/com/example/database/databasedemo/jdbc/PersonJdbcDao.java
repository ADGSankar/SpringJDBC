package com.example.database.databasedemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.database.databasedemo.entity.Person;


@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll()
	{
		 return jdbcTemplate.query("select * from person",new BeanPropertyRowMapper<Person>(Person.class));
	}
		
	public List<Person> findById(int id)
	{
		//  ? is mapped with new Object[] {id}
		 return jdbcTemplate.query("select * from person where id=?",new Object[] {id},new BeanPropertyRowMapper<Person>(Person.class));
	}
	public int deleteById(int id)
	{
		//  ? is mapped with new Object[] {id}
		//we can add more fields by "delete from person where id=? and name=? and ...",new Object[] {id,name,...}
		 return jdbcTemplate.update("delete from person where id=?",new Object[] {id});
	}
	public int insert(Person person)
	{
		 return jdbcTemplate.update("insert into person"
		 		+ "(id,name,location,birth_date) values (?,?,?,?)",
		 		new Object[] {person.getId(),person.getName(),person.getLocation(),person.getBirthDate()});
	}
	public int update(Person person)
	{
		 return jdbcTemplate.update("update person set name=? , location=? , birth_date=? where id=?",
		 		new Object[] {person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime()),person.getId(),});
	}
	
	
	
}
