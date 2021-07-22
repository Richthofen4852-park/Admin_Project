package com.fastcampus.javaallinone.project3.demo.controller;

import com.fastcampus.javaallinone.project3.demo.domain.Person;
import com.fastcampus.javaallinone.project3.demo.repository.PersonRepository;
import com.fastcampus.javaallinone.project3.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public void postPerson(@RequestBody Person person) {

        personService.put(person);

        log.info("person -> {} ", personRepository.findAll());
    }
}
