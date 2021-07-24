package com.fastcampus.javaallinone.project3.demo.service;

import com.fastcampus.javaallinone.project3.demo.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static java.time.LocalDate.now;
import static java.time.LocalDate.of;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void getPeopleByName() {
        List<Person> result = personService.getPeopleByName("martin");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("martin");
    }

    @Test
    void getPerson() {
        Person person = personService.getPerson(3L);

        assertThat(person.getName()).isEqualTo("dennis");
    }

}