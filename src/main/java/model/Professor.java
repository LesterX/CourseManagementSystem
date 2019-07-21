package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;;

@Entity
@Embeddable
@NamedQuery(name = "Professor.findAll", query="SELECT p FROM Professor p ORDER BY p.id")
public class Professor extends User {
    
    @Column(name="salary")
    private int salary;

    protected Professor() {super();}

    public Professor(long id, String firstName, String lastName) {
        super(id,firstName,lastName);
    }

    public Professor(long id, String firstName, String lastName, int salary) {
        super(id, firstName,lastName);
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