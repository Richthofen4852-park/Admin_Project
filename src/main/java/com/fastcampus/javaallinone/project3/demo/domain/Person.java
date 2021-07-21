package com.fastcampus.javaallinone.project3.demo.domain;

import com.fastcampus.javaallinone.project3.demo.domain.dto.Birthday;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int age;
    
    private String hobby;

    @NonNull
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
}
