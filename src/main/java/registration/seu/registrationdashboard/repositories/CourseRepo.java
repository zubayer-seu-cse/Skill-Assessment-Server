package registration.seu.registrationdashboard.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import registration.seu.registrationdashboard.Entities.Course;

public interface CourseRepo extends MongoRepository<Course, String> {
}
