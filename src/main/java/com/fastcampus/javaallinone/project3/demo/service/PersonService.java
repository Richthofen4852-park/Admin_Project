package com.fastcampus.javaallinone.project3.demo.service;

import com.fastcampus.javaallinone.project3.demo.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.demo.domain.Person;
import com.fastcampus.javaallinone.project3.demo.exception.PersonNotFoundException;
import com.fastcampus.javaallinone.project3.demo.exception.RenameNotPermitException;
import com.fastcampus.javaallinone.project3.demo.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleByName(String name) {
//        List<Person> people = personRepository.findAll();
//
//        return people.stream().filter(person -> person.getName().equals(name)).collect(Collectors.toList());

        return personRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);

        return person;
    }

    @Transactional
    public void put(PersonDto personDto) {
        Person person = new Person();
        person.set(personDto);
        person.setName(personDto.getName());

        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, PersonDto personDto) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());

        if(!person.getName().equals(personDto.getName())) {
            throw new RenameNotPermitException();
        }

        person.set(personDto);

        personRepository.save(person);
    }

    @Transactional
    public void modify(Long id, String name) {
        Person person = personRepository.findById(id).orElseThrow(PersonNotFoundException::new);

        person.setName(name);
        personRepository.save(person);
    }

    @Transactional
    public void delete(Long id) {

        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException());

        person.setDeleted(true);

        personRepository.save(person);
    }

    public Page<Person> getAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }
}
