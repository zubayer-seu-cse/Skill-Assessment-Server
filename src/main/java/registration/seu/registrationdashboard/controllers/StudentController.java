package registration.seu.registrationdashboard.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import registration.seu.registrationdashboard.Entities.Student;
import registration.seu.registrationdashboard.repositories.StudentRepo;

@RestController
@CrossOrigin("*")
public class StudentController {
    StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

//    @PostMapping("/create-student")
//    Student createStudent(@RequestBody Student student){
//
//    }

}
