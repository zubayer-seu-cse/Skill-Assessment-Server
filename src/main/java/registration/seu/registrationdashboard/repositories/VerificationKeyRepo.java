package registration.seu.registrationdashboard.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import registration.seu.registrationdashboard.Entities.VerificationKey;

public interface VerificationKeyRepo extends MongoRepository<VerificationKey, String> {
    VerificationKey findByUniqueKey(String key);
}
