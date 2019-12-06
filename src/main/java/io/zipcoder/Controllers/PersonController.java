package io.zipcoder.Controllers;

import io.zipcoder.Models.Person;
import io.zipcoder.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonRepository personRepository;
    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(personRepository.findOne(id), HttpStatus.OK);

    }
    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person){
        Person originalPerson= personRepository.findOne(id); // todo get()
        originalPerson.setFirstname(person.getFirstname());
        originalPerson.setLastname(person.getLastname());
        return new ResponseEntity<>(personRepository.save(originalPerson), HttpStatus.OK);
    }
    @DeleteMapping("/people/{id}")
    public void DeletePerson(@PathVariable Long id){
        personRepository.delete(id);

    }
}
