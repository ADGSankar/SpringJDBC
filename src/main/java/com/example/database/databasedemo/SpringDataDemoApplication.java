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
import com.example.database.databasedemo.jpa.PersonJpaRepository;
import com.example.database.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(SpringDataDemoApplication.class);
	
	@Autowired
	PersonSpringDataRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		logger.info("Users details of 10001  -> {}",repository.findById(10001));		
		logger.info("updating 10003 -> {}",repository.save(new Person(10003,"Sam","Chennai",new Date())));
//		logger.info("Inserting 10004 -> {}",repository.update(new Person(10004,"Samar","Mumbai",new Date())));
		logger.info("Inserting 10004 -> {}",repository.save(new Person("Amar","Mumbai",new Date())));
		logger.info("Inserting 10004 -> {}",repository.save(new Person("Amar","Mumbai",new Date())));
		repository.deleteById(10002);
		logger.info("All users -> {}",repository.findAll());
		//		logger.info("Deleting 10002 -> No of rows deleted -> {}",dao.deleteById(10002));


	}

}
