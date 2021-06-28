package com.yahitesh;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yahitesh.entity.Person;
import com.yahitesh.jdbc.PersonJdbcDao;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class SpringbootJdbcJpaHibernateApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJdbcJpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("find All Person -> {}", dao.findAll());
		log.info("find Person By Id 10001 -> {}", dao.findById(10001));
		log.info("delete Person By Id 10002 No of row deleted -> {}", dao.deleteById(10002));
		log.info("Insert Person For Id 1004 -> {}", dao.insert(new Person(10004,"Peter", "Berlin", new Date())));
		log.info("Update Person For Id 1003 -> {}", dao.update(new Person(10003,"Pavan", "Delhi", new Date())));
	}

}
