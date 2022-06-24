package com.safetynet.SafetyNetAlerts.controller;

import com.safetynet.SafetyNetAlerts.model.PersonModel;
import com.safetynet.SafetyNetAlerts.service.PersonService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/persons")
@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PutMapping("persons")
    public PersonModel updatePerson(@RequestBody PersonModel personModel) throws IOException, ParseException {
        personService.updatePerson(personModel);
        return personModel;
    }

    @PostMapping("persons")
    public ResponseEntity<String> createPerson(@RequestBody PersonModel personModel) throws IOException, ParseException {
        personService.createPerson(personModel);
        return ResponseEntity.ok("Person ceated");
    }

    @DeleteMapping("persons")
    public String deletePerson(@RequestBody PersonModel personModel) throws IOException, ParseException {
        personService.deletePerson(personModel);
        return "This person is probably dead";
    }

}