package registration.seu.registrationdashboard.controllers;

import org.springframework.web.bind.annotation.*;
import registration.seu.registrationdashboard.Entities.AssignedCoursesInfo;
import registration.seu.registrationdashboard.Entities.Course;
import registration.seu.registrationdashboard.Entities.Student;
import registration.seu.registrationdashboard.repositories.StudentRepo;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {
    StudentRepo studentRepo;

    public StudentController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @PostMapping("/create-student")
    Student createStudent(@RequestBody Student student) {
        if (studentRepo.findByStudentId(student.studentId()) != null) {
            return studentRepo.save(student);
        } else{
            return null;
        }
    }

    @GetMapping("get-student-list")
    List<Student> getCourseList() {
        return studentRepo.findAll();
    }
    @GetMapping("get-student-info/{studentId}")
    Student getStudentInfo(@PathVariable String studentId) {
        return studentRepo.findByStudentId(studentId);
    }

    @PostMapping("assign-courses")
    void assignCourses(@RequestBody AssignedCoursesInfo assignedCoursesInfo) {
        String _id = assignedCoursesInfo.selectedStudent().studentId();
        List<Course> assignedCourses = assignedCoursesInfo.selectedCourses();
        studentRepo.findAndPushAssignedCoursesByStudentId(_id, assignedCourses);
    }

}
