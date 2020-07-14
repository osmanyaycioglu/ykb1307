package com.training.ykb;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person/v2")
public class PersonRest3 {

    @Autowired
    private PersonManager pm;

    @PostMapping("/add")
    public String addPerson(@RequestBody final Person person) {
        this.pm.addPerson(person);
        return "OK";
    }

    @PostMapping("/add2")
    public String addPerson2(@RequestBody final Person person) {
        this.pm.addPerson(person);
        return "OK";
    }

    @PostMapping("/update")
    public String updatePerson(@RequestBody final Person person) {
        this.pm.addPerson(person);
        return "OK";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("id") final String uid) {
        this.pm.deletePerson(uid);
        return "OK";
    }

    @GetMapping("/get")
    public Person getPerson(@RequestParam("id") final String uid) {
        return this.pm.getPerson(uid);
    }

    @GetMapping("/getall")
    public Collection<Person> getAllPersons() {
        return this.pm.getAll();
    }

    @GetMapping("/account/getall")
    public Collection<String> getAllPersonAccounts() {
        return null;
    }

}
