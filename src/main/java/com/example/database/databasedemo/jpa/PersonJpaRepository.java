package com.example.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id)
	{
		return entityManager.find(Person.class, id);
	}
	public Person update(Person person)
	{
		return entityManager.merge(person);
	}
	public void deleteById(int id)
	{
		Person person=findById(id);
		entityManager.remove(person);
	}
	
}
