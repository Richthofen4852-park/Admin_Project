package com.fastcampus.javaallinone.project3.demo.domain;

import com.fastcampus.javaallinone.project3.demo.controller.dto.PersonDto;
import com.fastcampus.javaallinone.project3.demo.domain.dto.Birthday;
import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(1)
    private int age;
    
    private String hobby;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;
    
    private String address;

    @Valid
    @Embedded
    private Birthday birthday;

    private String job;

    @ToString.Exclude
    private String phoneNumber;

    @OneToOne(cascade = ALL, orphanRemoval = true)
    @ToString.Exclude
    private Block block;

    public void set(PersonDto personDto) {
        if(personDto.getAge() != 0)
            this.setAge(personDto.getAge());

        if(!StringUtils.isEmpty(personDto.getHobby()))
            this.setHobby(personDto.getHobby());

        if(!StringUtils.isEmpty(personDto.getBloodType()))
            this.setBloodType(personDto.getBloodType());

        if(!StringUtils.isEmpty(personDto.getAddress()))
            this.setAddress(personDto.getAddress());

        if(!StringUtils.isEmpty(personDto.getJob()))
            this.setJob(personDto.getJob());

        if(!StringUtils.isEmpty(personDto.getPhoneNumber()))
            this.setPhoneNumber(personDto.getPhoneNumber());
    }
}
