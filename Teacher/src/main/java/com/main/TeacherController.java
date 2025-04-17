package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.main.Student.StudentMaster;

@RestController
public class TeacherController {

	@Autowired
	private RestTemplate restTemplate; 

	@GetMapping("/hello")
	public String hello(@RequestHeader(value = "X-Teacher-Gateway", required = false) String header) {
		return "hello Teacher is here..." + "  header : " + header ;
	}
	
	
	List<TeacherMaster> list = new ArrayList<>(); 
	
	
	@PostMapping("/")
	public ResponseEntity<TeacherMaster> saveTeacher(@RequestBody TeacherMaster teacher){
		list.add(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacher);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TeacherMaster>> getAllTeacher(){
		return ResponseEntity.ok(list);
	}


	@GetMapping("/getAllStudent")
	public ResponseEntity<List<StudentMaster>> getAllStudent(
//			@RequestHeader("Authorization") String authHeader,
			@RequestHeader("API-Key") String apiKey
	){

//		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); // Invalid header
//	    }
		
//		String token = authHeader.replace("Bearer ", "");
//		System.out.println("Received token : " + token);
		
		String url = "http://localhost:8082/student/getAllStudent";
		
//		ResponseEntity<StudentMaster[]> response = restTemplate.getForEntity(url, StudentMaster[].class);
// 		List<StudentMaster> list = Arrays.asList(response.getBody());
 		
		HttpHeaders headers = new HttpHeaders();
		headers.set("API-Key", "123");
//		headers.set("Authorization", "Bearer " + token);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		ResponseEntity<List<StudentMaster>> response = restTemplate
				.exchange(
						url,
						HttpMethod.GET,
						entity,
						new ParameterizedTypeReference<List<StudentMaster>>() {
		});
		
		List<StudentMaster> list = response.getBody();
		
		return ResponseEntity.ok(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
