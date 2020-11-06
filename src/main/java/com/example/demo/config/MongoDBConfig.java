package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDBConfig extends AbstractMongoClientConfiguration  {

	
	@Value("${spring.data.mongdb.url")
	private String url;
	@Value("${spring.data.mongdb.database")
	private String database;
	
	
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		System.out.println("mongodb init");
		System.out.println("mongodb url : "+url);		
		System.out.println("mongodb database : "+database);
		
		
		return database;
	} 
	
	@Override
	public MongoClient mongoClient() {
		
		return MongoClients.create("mongodb://52.79.42.170:27018");
	}
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception{
		MongoDatabaseFactory databaseFactory = new SimpleMongoClientDatabaseFactory(mongoClient(), database);
		MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(databaseFactory), new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return new MongoTemplate(databaseFactory,converter);
	}
 

	
	
}

