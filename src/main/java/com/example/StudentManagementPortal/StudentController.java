package com.example.StudentManagementPortal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    studentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int admnNo){
        Student s = studentService.getStudent(admnNo);
        if(s == null){
            return new ResponseEntity("Student Not Found" , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(studentService.getStudent(admnNo) , HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")                // ("") we pass the end point for our API
    public ResponseEntity addStudent(@RequestBody Student student){   // request body for a object
        String s = studentService.addStudent(student);
        return new ResponseEntity(s , HttpStatus.CREATED);
    }

    // get student by path variable

    @GetMapping("/get_info/{id}")
    public ResponseEntity getStudentbyPath(@PathVariable("id") int admnNo){
        Student s = studentService.getStudentbyPath(admnNo);
        if(s == null){
            return new ResponseEntity("Student Not Found" , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(studentService.getStudentbyPath(admnNo) , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteStudent(@RequestParam("id") int adminNo){
        return new ResponseEntity(studentService.deleteStudent(adminNo) , HttpStatus.ACCEPTED);
    }

    @PutMapping("/update_course")
    public ResponseEntity updatecourse(@RequestParam("id") int adminNo , @RequestParam("course") String newcourse){
        return new ResponseEntity(studentService.updateCourse(adminNo , newcourse) , HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_above25")
    public ResponseEntity getAbove25(){
        return new ResponseEntity(studentService.getAbove25() , HttpStatus.FOUND);
    }
}
