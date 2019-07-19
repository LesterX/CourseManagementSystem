package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class Professor extends User {
    
    @Column(name="salary")
    private int salary;

    protected Professor() {super();}

    public Professor(String firstName, String lastName, int salary) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Professor " + this.getFirstName() + " " + 
            this.getLastName() + "  Salary : " + salary;
    }
}