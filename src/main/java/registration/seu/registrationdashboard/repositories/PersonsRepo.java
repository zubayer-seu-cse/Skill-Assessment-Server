package registration.seu.registrationdashboard.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import registration.seu.registrationdashboard.Entities.Person;

public interface PersonsRepo extends MongoRepository<Person, String> {
    Person findByEmail(String email);
    Person findByUsernameAndPassword(String username, String password);
}
