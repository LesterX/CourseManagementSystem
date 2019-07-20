package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Professor extends User {
    
    @Column(name="salary")
    private int salary;

    protected Professor() {super();}

    public Professor(String firstName, String lastName) {
        super(firstName,lastName);
    }

    public Professor(String firstName, String lastName, int salary) {
        super(firstName,lastName);
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
        String s = salary == 0 ? "N/A" : Integer.toString(salary);

        return "Professor ID " + this.getId() + ": " + this.getFirstName() + " " + 
            this.getLastName() + "  Salary : " + s;
    }
}