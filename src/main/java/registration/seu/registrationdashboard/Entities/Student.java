package registration.seu.registrationdashboard.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
public record Student(@Id String _id,
                      String studentId,
                      Name studentName,
                      String gender,
                      List<String> phoneNumbers,
                      List<Education> educations,
                      String address
) { }
