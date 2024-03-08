package com.application.MongoDB.controller;

import com.application.MongoDB.entity.Student;
import com.application.MongoDB.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    //http://localhost:8080/api/student/create
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return  studentService.createStudent(student);
    }

    //http://localhost:8080/api/student/getById/65eaa994f57d3a608fb9cdb3
    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return  studentService.getStudentById(id);
    }

    //http://localhost:8080/api/student/all
    @GetMapping("/all")
    public List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    //http://localhost:8080/api/student/update
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }


    //http://localhost:8080/api/student/delete/65eab448078e645f9669471a
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    //http://localhost:8080/api/student/studentsByName/Raj-1
    @GetMapping("/studentsByName/{name}")
    public List<Student> studentsByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    //http://localhost:8080/api/student/studentsByNameAndMail?name=Raj-1&email=raj-1@gmail.com
    @GetMapping("/studentsByNameAndMail")
    public Student studentsByNameAndMail(@RequestParam String name,
                                               @RequestParam String email) {
        return studentService.getStudentsByNameAndMail(name, email);
    }

    //    //http://localhost:8080/api/student/studentsByNameOrMail?name=Raj&email=Ani-1@gmail.com
    @GetMapping("/studentsByNameOrMail")
    public List<Student> studentByNameOrMail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentsByNameOrMail(name,email);
    }

    //http://localhost:8080/api/student/allWithPagination?pageNo=1&pageSize=10
    @GetMapping("/allWithPagination") //formula: (Page NO - 1)* PageSize
    public List<Student> getAllWithPagination(@RequestParam int pageNo,
                                              @RequestParam int pageSize) {
        return studentService.getAllWithPagination(pageNo,pageSize);
    }

    //http://localhost:8080/api/student/allWithSorting
    @GetMapping("/allWithSorting")
    public List<Student> allWithSorting() {
        return studentService.allWithSorting();
    }

    //"department.department_name:"Computer Science"
    //http://localhost:8080/api/student/byDepartmentName?deptName=Computer Science
    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName(@RequestParam String deptName) {
        return studentService.byDepartmentName(deptName);
    }

    //"subject.subject_name":"Java"
    //http://localhost:8080/api/student/bySubjectName?subName=Java
    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subName) {
        return studentService.bySubjectName(subName);
    }

    //"mail" : /yahoo/
    //http://localhost:8080/api/student/emailLike?email=gmail
    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email) {
        return studentService.emailLike(email);
    }

    //"name":/^Jhon/
    //http://localhost:8080/api/student/nameStartsWith?name=Raj
    @GetMapping("/nameStartsWith")
    public List<Student> nameStartWith(@RequestParam String name) {
        return studentService.nameStartsWith(name);
    }

    //http://localhost:8080/api/student/byDepartmentId?deptId=65eb0db5d7f70874946fee7a
    @GetMapping("/byDepartmentId")
    public List<Student> byDepartmentId(@RequestParam String deptId) {
        return studentService.byDepartmentId(deptId);
    }
}
