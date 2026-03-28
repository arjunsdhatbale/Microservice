package com.main.controller;

import java.util.ArrayList;
import java.util.List;

import com.main.model.StudentMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String EXPECTED_API_KEY = "123";  // Teacher API key
	 
	@GetMapping("/hello")
	public String getHello() {
        logger.info("Request received to get Hello from Student Service.");
		return "I am from Student service.";
	}
	
	List<StudentMaster> list = new ArrayList<>();
	
	@GetMapping("/")
	public String home() {
		return "test";
	}
	@PostMapping("/saveStudent")
	public ResponseEntity<StudentMaster> addStudent(@RequestBody StudentMaster studentMaster){
		list.add(studentMaster);
		return new ResponseEntity<StudentMaster>(studentMaster,HttpStatus.CREATED);
	}

	@GetMapping("/getAllStudent")
	public ResponseEntity<List<StudentMaster>> getAllStudent(
			@RequestHeader("API-Key") String apiKey){
		if(!EXPECTED_API_KEY.equals(apiKey)) {
			return ResponseEntity.status(401).body(null);
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/users")
	public String getAllUser() {
		String url = "https://localhost:7068/api/user";
		return restTemplate.getForObject(url, String.class);
	}
	
	
}
