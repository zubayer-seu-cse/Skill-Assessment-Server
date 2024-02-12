package registration.seu.registrationdashboard.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;
import registration.seu.registrationdashboard.Entities.AssignedCoursesInfo;
import registration.seu.registrationdashboard.Entities.Course;
import registration.seu.registrationdashboard.Entities.Student;

import java.util.List;

public interface StudentRepo extends MongoRepository<Student, String> {

    Student findByStudentId(String studentId);
    @Update("{ '$addToSet': { 'assignedCourses': {'$each': ?1} } }")
    void findAndPushAssignedCoursesByStudentId(String _id, List<Course> assignedCourses);
}
