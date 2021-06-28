package com.yahitesh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		log.info("find All -> {}", dao.findAll());
	}

}
