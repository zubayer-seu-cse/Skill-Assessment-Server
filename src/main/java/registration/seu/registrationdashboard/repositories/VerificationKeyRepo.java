package registration.seu.registrationdashboard.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import registration.seu.registrationdashboard.Entities.VerificationKey;

public interface VerificationKeyRepo extends MongoRepository<VerificationKey, String> {
    // this custom query method is used to see if the provided key is present in the database.
    VerificationKey findByUniqueKey(String key);
}
