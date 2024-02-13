package registration.seu.registrationdashboard.repositories;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.NonNullApi;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import registration.seu.registrationdashboard.Entities.Course;

import java.util.List;

public interface CourseRepo extends MongoRepository<Course, String> {
    @Aggregation("{$search: {index: coursesSearch, text: {query: ?0, path: ['courseTitle', 'courseCode', 'credits']}}}")
    List<Course> search(String keyword);
}
