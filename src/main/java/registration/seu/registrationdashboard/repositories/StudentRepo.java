package registration.seu.registrationdashboard.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import registration.seu.registrationdashboard.Entities.Student;

public interface StudentRepo extends MongoRepository<Student, String> {
}
