package com.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {
	@Autowired
	private RestTemplate restTemplate;
	
	private static final String EXPECTED_API_KEY = "123";  // Teacher API key
	 
	@GetMapping("/hello")
	public String getHello(@RequestHeader(value = "X-Student-Gateway", required =  false) String headerValue ) {
		return "Hello Students Arjun is here ..." +  " header : " + headerValue;
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
