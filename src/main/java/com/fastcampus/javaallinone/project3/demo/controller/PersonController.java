package com.fastcampus.javaallinone.project3.demo.controller;

import com.fastcampus.javaallinone.project3.demo.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.demo.domain.Person;
import com.fastcampus.javaallinone.project3.demo.exception.PersonNotFoundException;
import com.fastcampus.javaallinone.project3.demo.exception.RenameNotPermitException;
import com.fastcampus.javaallinone.project3.demo.exception.dto.ErrorResponse;
import com.fastcampus.javaallinone.project3.demo.repository.PersonRepository;
import com.fastcampus.javaallinone.project3.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public Person getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }

    @PostMapping("")
    @ResponseStatus(CREATED)
    public void postPerson(@RequestBody @Valid PersonDto personDto) {
        personService.put(personDto);
    }

    @PutMapping("{id}")
    public void modifyPerson(@PathVariable Long id, @RequestBody PersonDto personDto) {
        personService.modify(id, personDto);
    }

    @PatchMapping("{id}")
    public void modifyPerson(@PathVariable Long id, String name) {
        personService.modify(id, name);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);
    }

}
