package com.boot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.model.cd;

public interface cdRepo extends MongoRepository<cd, String>{

	public cd findOneByName(String id);
	
}
