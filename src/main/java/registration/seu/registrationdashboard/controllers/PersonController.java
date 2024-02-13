package registration.seu.registrationdashboard.controllers;

import org.springframework.web.bind.annotation.*;
import registration.seu.registrationdashboard.Entities.ErrorMessage;
import registration.seu.registrationdashboard.Entities.Person;
import registration.seu.registrationdashboard.repositories.PersonsRepo;
import registration.seu.registrationdashboard.repositories.VerificationKeyRepo;

@RestController
@CrossOrigin("*")
public class PersonController {
    private final PersonsRepo personsRepo;
    private final VerificationKeyRepo verificationKeyRepo;

    PersonController(PersonsRepo personsRepo, VerificationKeyRepo verificationKeyRepo) {
        this.personsRepo = personsRepo;
        this.verificationKeyRepo = verificationKeyRepo;
    }

    @PostMapping("/login")
    Person login(@RequestBody Person person) {
        return personsRepo.findByUsernameAndPassword(person.username(), person.password());
    }

    @PostMapping("/create-admin-account")
    Person createAdminAccount(@RequestBody Person person) {
        // this line is checking if any other person have already been register with the same
        // email or not. And if the provided verification key is present in the database
        if (personsRepo.findByEmail(person.email()) == null
                &&
                verificationKeyRepo.findByUniqueKey(person.verification_key()) != null) {
            return personsRepo.save(person);
        } else {
            return null;
        }
    }
}
