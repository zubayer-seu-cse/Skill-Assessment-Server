package registration.seu.registrationdashboard.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("courses")
public record Course(@Id String _id, String courseCode, String courseTitle, String credits) {  }
