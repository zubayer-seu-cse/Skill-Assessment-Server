package registration.seu.registrationdashboard.controllers;

import org.springframework.web.bind.annotation.*;
import registration.seu.registrationdashboard.Entities.AssignedCoursesInfo;
import registration.seu.registrationdashboard.Entities.Course;
import registration.seu.registrationdashboard.repositories.CourseRepo;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {
    private final CourseRepo courseRepo;

    public CourseController(CourseRepo courseRepo){
        this.courseRepo = courseRepo;
    }

    @PostMapping("create-course")
    Course createCourse(@RequestBody Course course){
        return courseRepo.save(course);
    }

    @GetMapping("get-course-list")
    List<Course> getCourseList(){
        return courseRepo.findAll();
    }

    @DeleteMapping("delete-course/{_id}")
    boolean deleteCourse(@PathVariable String _id){
        courseRepo.deleteById(_id);
        return true;
    }

    @GetMapping("search-courses/{keyword}")
    List<Course> searchCourses(@PathVariable String keyword){
        return courseRepo.search(keyword);
    }
}
