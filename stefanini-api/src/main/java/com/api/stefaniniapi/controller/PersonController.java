package com.api.stefaniniapi.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.stefaniniapi.exception.ResourceNotFoundException;
import com.api.stefaniniapi.model.Person;
import com.api.stefaniniapi.repository.PersonRepository;
import util.Assert;
import util.validateCPF;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("/persons")
    public ResponseEntity<?> createPerson(@Valid @RequestBody Person person) throws ResourceNotFoundException  {

        Person personReturn = personRepository.findByCpf(person.getCpf());
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", "404");
        body.put("error","Not Found");
        if (Assert.isNotNull(personReturn)) {
            body.put("message", "CPF already exists :: " + person.getCpf());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
        }
        if (validateCPF.isCPF(person.getCpf()) && Assert.isNull(personReturn)){
            person.setDateRegis(new Date());
            return ResponseEntity.ok().body(personRepository.save(person));
        }
        body.put("message", "CPF invalid :: " + person.getCpf());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable(value = "id") Long personId,
                                                   @Valid @RequestBody Person personDetails) throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        String  cpf = personDetails.getCpf().replace( " " , "").replace(".","").replace("-","");
        if (validateCPF.isCPF(cpf)){
            person.setEmailId(personDetails.getEmailId());
            person.setFullName(personDetails.getFullName());
            person.setGender(personDetails.getGender());
            person.setEmailId(personDetails.getEmailId());
            person.setDateBirth(personDetails.getDateBirth());
            person.setPlaceBirth(personDetails.getPlaceBirth());
            person.setNationality(personDetails.getNationality());
            person.setCpf(personDetails.getCpf());
            person.setDateRegis(person.getDateRegis());
            person.setDateUpdate(personDetails.getDateUpdate());
            person.setDateUpdate(new Date());
            final Person updatedEmployee = personRepository.save(person);
            return ResponseEntity.ok(updatedEmployee);
        }
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", "404");
        body.put("error","Not Found");
        body.put("message", "CPF invalid :: " + personDetails.getCpf());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @DeleteMapping("/persons/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
