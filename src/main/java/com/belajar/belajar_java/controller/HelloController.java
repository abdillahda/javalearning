package com.belajar.belajar_java.controller;


import com.belajar.belajar_java.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    List<Person> personList = new ArrayList<>();

    @GetMapping("/hello")
    public Person hello(){
        return new Person("Budi",30);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person){
        personList.add(person);
        return person;
    }

    @GetMapping("/person/{nama}")
    public Person getPersonList(@PathVariable String nama){
        for (Person value : personList) {
            if (value.getNama().equals(nama)) {
                return value;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
    }

    @PutMapping("/person/{nama}")
    public Person updatePerson(@PathVariable String nama, @RequestBody Person person){
        for (Person value : personList) {
            if (value.getNama().equals(nama)) {
                value.setUmur(person.getUmur());
                value.setNama(person.getNama());
                return value;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");

    }

    @DeleteMapping("/person/{nama}")
    public ResponseEntity<String> deletePerson(@PathVariable String nama, @RequestBody Person person){
        for (Person value : personList) {
            if (value.getNama().equals(nama)) {
                personList.remove(value);
                return ResponseEntity.ok("Sukses Delete");
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
    }

}
