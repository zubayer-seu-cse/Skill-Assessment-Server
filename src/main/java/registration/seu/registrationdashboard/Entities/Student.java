package registration.seu.registrationdashboard.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
public record Student(
        @Id String _id,
        String studentId,
        Name name,
        String gender,
        List<String> phones,
        List<Education> education,
        String address
) {
}
