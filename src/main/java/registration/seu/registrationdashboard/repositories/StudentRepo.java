package registration.seu.registrationdashboard.repositories;

import com.mongodb.client.MongoClient;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;
import registration.seu.registrationdashboard.Entities.AssignedCoursesInfo;
import registration.seu.registrationdashboard.Entities.Course;
import registration.seu.registrationdashboard.Entities.Student;

import java.util.List;

import java.util.Arrays;

import org.bson.Document;
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.concurrent.TimeUnit;

import org.bson.Document;
import com.mongodb.client.AggregateIterable;

public interface StudentRepo extends MongoRepository<Student, String> {
    Student findByStudentId(String studentId);

    // this updates the assigned courses to the student
    @Update("{ '$addToSet': { 'assignedCourses': {'$each': ?1} } }")
    void findAndPushAssignedCoursesByStudentId(String _id, List<Course> assignedCourses);

    // this pipeline searches in the student id, gender, name and phone numbers
    @Aggregation("{$search: {index: studentSearch, text: {query: ?0, path: ['studentId', 'gender', 'name.firstName', 'name.middleName', 'name.lastName', 'phones']}}}")
    List<Student> search(String keyword);
}
