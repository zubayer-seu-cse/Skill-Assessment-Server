package registration.seu.registrationdashboard.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import registration.seu.registrationdashboard.Entities.Course;
import registration.seu.registrationdashboard.repositories.CourseRepo;

@RestController
@CrossOrigin("*")
public class CourseController {
    private final CourseRepo courseRepo;

    public CourseController(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }


    @PostMapping("create-course")
    Course createCourse(@RequestBody Course course){
        System.out.println(course.courseCode());


        Course addedCourse = courseRepo.save(course);

        if(addedCourse != null){
            return addedCourse;
        } else {
            return new Course("N/A", "N/A", "N/A", 0);
        }
    }
}