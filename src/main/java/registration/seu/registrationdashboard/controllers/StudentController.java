package registration.seu.registrationdashboard.controllers;

import org.springframework.web.bind.annotation.*;
import registration.seu.registrationdashboard.Entities.Course;
import registration.seu.registrationdashboard.Entities.Student;
import registration.seu.registrationdashboard.repositories.StudentRepo;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {
    StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    @PostMapping("/create-student")
    Student createStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @GetMapping("get-student-list")
    List<Student> getCourseList(){
        return studentRepo.findAll();
    }

}
