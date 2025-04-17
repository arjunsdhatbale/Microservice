//package com.main.Student;
//
//import com.main.Config.FeignConfig;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@FeignClient(name = "student-service",url = "http://localhost:8082",configuration = FeignConfig.class)
//public interface StudentClient {
//
//
//    @GetMapping("/student/getAllStudent")
//    public ResponseEntity<List<StudentMaster>> getAllStudent();
//}
