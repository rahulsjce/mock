package com.springboot.rest.example.springbootuserapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class ApplicationConfig {

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		return new SimpleMongoDbFactory(mongoClient, "Account_Data");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}

}