package com.boot.controller;

import com.boot.model.cd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import com.boot.repository.cdRepo;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/cd")
public class cdController {
	
	private final Logger logger = Logger.getLogger(cdController.class.getName());
	
	@Autowired
	cdRepo cdRepo;	 
	//s
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody cd cd){
		logger.info(cd.getName());
		cdRepo.save(cd);
	}
	
	@RequestMapping(value = "/{id}")
	public cd read(@PathVariable String  id){
        Optional<cd> optCD = cdRepo.findById(id);
        if (optCD.isPresent()) {
            return optCD.get();
        } return null;
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(cd id){
		cdRepo.save(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		cdRepo.deleteById(id);
		
	}
	
}
