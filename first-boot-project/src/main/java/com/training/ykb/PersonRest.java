package com.training.ykb;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonRest {

    @Autowired
    private PersonManager pm;

    @PutMapping
    public String addPerson(@Validated @RequestBody final Person person) {
        // Validation code
        if (person.getAge() == 50) {
            throw new IllegalArgumentException("age 50 olamaz");
        }
        if (person.getAge() == 51) {
            throw new IllegalStateException("51 olamaz");
        }

        this.pm.addPerson(person);
        return "OK";
    }

    @PatchMapping
    public String updatePerson(@RequestBody final Person person) {
        this.pm.addPerson(person);
        return "OK";
    }

    @DeleteMapping
    public String deletePerson(@RequestParam("id") final String uid) {
        this.pm.deletePerson(uid);
        return "OK";
    }

    @GetMapping
    public Person getPerson(@RequestParam("id") final String uid) {
        return this.pm.getPerson(uid);
    }

    @GetMapping("/all")
    public Collection<Person> getAllPersons() {
        return this.pm.getAll();
    }


}
