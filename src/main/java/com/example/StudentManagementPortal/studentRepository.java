package com.example.StudentManagementPortal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class studentRepository {

    Map<Integer , Student> studentDb = new HashMap<>();
    public Student getStudent(int admnNo) {
        return studentDb.get(admnNo);
    }

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getAdmiNo())){
            return "Student Already Present";
        }
        studentDb.put(student.getAdmiNo() , student);
        return "Student Added Successfully";
    }

    public Student getStudentbyPath(int admnNo) {
        return studentDb.get(admnNo);
    }

    public void deleteStudent(int adminNo) {
        studentDb.remove(adminNo);
    }

    public String updateCourse(int adminNo, String newcourse) {
        if(!studentDb.containsKey(adminNo)){
            throw new RuntimeException("Student Doesn't Exists");
        }
        Student s = studentDb.get(adminNo);
        s.setCourse(newcourse);

        return "Updated Successfully";
    }

    public int getAbove25() {
        int total = 0;
        for(int x : studentDb.keySet()){
            if(studentDb.get(x).getAge() > 25){
                total++;
            }
        }
        return total;
    }
}
