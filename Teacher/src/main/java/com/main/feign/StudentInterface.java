package com.main.feign;

import com.main.Student.StudentMaster;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("STUDENT-SERVICE")
public interface StudentInterface {

    @GetMapping("/student/hello")
    public String getHello( );



    @PostMapping("/saveStudent")
    public ResponseEntity<StudentMaster> addStudent(@RequestBody StudentMaster studentMaster);

    @GetMapping("/users")
    public String getAllUser();
}
