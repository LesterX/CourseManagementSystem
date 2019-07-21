package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends User {

    @Column(name = "studentNum")
    private long studentNum;

    public Student() {super();}

    public Student(long id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
}