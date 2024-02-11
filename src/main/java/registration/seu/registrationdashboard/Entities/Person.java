package registration.seu.registrationdashboard.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
public record Person (@Id String _id, String username, String password) { }