package registration.seu.registrationdashboard.controllers;

import org.springframework.web.bind.annotation.*;
import registration.seu.registrationdashboard.Entities.ErrorMessage;
import registration.seu.registrationdashboard.Entities.Person;
import registration.seu.registrationdashboard.repositories.PersonsRepo;

@RestController
@CrossOrigin("*")
public class PersonController {
    private final PersonsRepo personsRepo;

    PersonController(PersonsRepo personsRepo){
        this.personsRepo = personsRepo;
    }

    @PostMapping("/login")
    Person login(@RequestBody Person person){
        Person fetchedPerson = personsRepo.findByUsernameAndPassword(person.username(), person.password());
        if(fetchedPerson != null){
            return fetchedPerson;
        } else {
            return new Person("N/A", "N/A", "N/A");
        }
    }
}