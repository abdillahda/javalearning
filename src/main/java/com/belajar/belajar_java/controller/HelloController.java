package com.belajar.belajar_java.controller;


import com.belajar.belajar_java.Person;
import com.belajar.belajar_java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    PersonRepository personRepository;


    @GetMapping("/hello")
    public Person hello(){
        return new Person("Budi",30);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person){
        personRepository.save(person);
        return person;
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPersonList(@PathVariable Long id){
        Optional<Person> person = personRepository.findById(id);
        if (person.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");

        }
        return person;
    }

    @PutMapping("/person/{id}")
    public Optional<Person> updatePerson(@PathVariable Long id, @RequestBody Person personReq){
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()){
            person.get().setNama(personReq.getNama());
            person.get().setUmur(personReq.getUmur());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
        }
        return person;

    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id, @RequestBody Person personReq){
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()){
            personRepository.delete(person.get());
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Data tidak ditemukan");
        }
        return ResponseEntity.ok("Sukses Delete");
    }

}
