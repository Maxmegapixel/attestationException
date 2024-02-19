package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String lastName, String firstName, String middleName, String birthDate, long phoneNumber, char gender) throws ParseException, InvalidGenderException {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.birthDate = dateFormat.parse(birthDate);
        this.phoneNumber = phoneNumber;
        if (gender != 'f' && gender != 'm') {
            throw new InvalidGenderException("Ошибка: пол должен быть указан как 'f' (женский) или 'm' (мужской).");
        }
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return lastName + " " + firstName + " " + middleName + " " + dateFormat.format(birthDate) + " " + phoneNumber + " " + gender;
    }
}