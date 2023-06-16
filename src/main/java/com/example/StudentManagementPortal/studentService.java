package com.example.StudentManagementPortal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class studentService {
    @Autowired
    studentRepository studentRepository;
    public Student getStudent(int admnNo) {
        return studentRepository.getStudent(admnNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public Student getStudentbyPath(int admnNo) {
        return studentRepository.getStudentbyPath(admnNo);

    }

    public String deleteStudent(int adminNo) {
        studentRepository.deleteStudent(adminNo);
        return "Student Deleted Successfully";
    }

    public String updateCourse(int adminNo, String newcourse) {
        return studentRepository.updateCourse(adminNo, newcourse);
    }

    public int getAbove25() {
        return studentRepository.getAbove25();
    }
}
