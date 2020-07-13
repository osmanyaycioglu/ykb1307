package com.training.ykb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyFirstRest {

    @GetMapping("/hello")
    public String hello() {
        return "Hello world GET";
    }

    @PostMapping("/hello")
    public String hello2() {
        return "Hello world POST";
    }

    @GetMapping("/hello3/{xyz}/{abc}")
    public String hello3(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello world 3 " + name + " " + surname;
    }

    @GetMapping("/hello4")
    public String hello4(@RequestParam("isim") final String name,
                         @RequestParam("soyisim") final String surname) {
        return "Hello world 4 " + name + " " + surname;
    }

    @GetMapping("/hello5/{xyz}/{abc}")
    public String hello5(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname,
                         @RequestParam("uvf") final int age) {
        return "Hello world 5 " + name + " " + surname + " " + age;
    }

    @GetMapping("/hello6")
    public String hello6(@RequestHeader("xyz") final String name,
                         @RequestHeader("abc") final String surname) {
        return "Hello world 6 " + name + " " + surname;
    }

    @PostMapping("/hello7")
    public String hello7(@RequestBody final Person person) {
        return "Hello world 6 " + person.getName() + " " + person.getSurname() + " " + person.getAge();
    }

}
