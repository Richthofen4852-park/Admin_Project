package com.fastcampus.javaallinone.project3.demo.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static javax.persistence.AccessType.FIELD;

@Embeddable
@NoArgsConstructor
@Data
public class Birthday {

    private Integer yearOfBirthday;

    private Integer monthOfBirthday;

    private Integer dayOfBirthday;

    public Birthday(LocalDate birthday) {
        this.yearOfBirthday = birthday.getYear();
        this.monthOfBirthday = birthday.getMonthValue();
        this.dayOfBirthday = birthday.getDayOfMonth();
    }

    @Access(FIELD)
    public int getAge() {
        return now().getYear() - this.yearOfBirthday + 1;
    }

    @Access(FIELD)
    public boolean isBirthdayToday() {
        return now().equals(LocalDate.of(yearOfBirthday, monthOfBirthday, dayOfBirthday));
    }

    public static Birthday of(LocalDate birthday) {
        return new Birthday(birthday);
    }
}
