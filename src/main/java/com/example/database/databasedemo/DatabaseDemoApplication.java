package com.example.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.database.databasedemo.entity.Person;
import com.example.database.databasedemo.jdbc.PersonJdbcDao;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(DatabaseDemoApplication.class);
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info("All users -> {}",dao.findAll());
		logger.info("Users details  -> {}",dao.findById(10001));		
		logger.info("Deleting 10002 -> No of rows deleted -> {}",dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}",dao.insert(new Person(10004,"Samar","Mumbai",new Date())));
		logger.info("updating 10003 -> {}",dao.update(new Person(10003,"Sam","Chennai",new Date())));
	}

}
