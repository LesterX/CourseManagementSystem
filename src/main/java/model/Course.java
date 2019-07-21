package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Course implements Serializable{
    @Id
    private long id;

    @Column(name = "name", unique = true)
    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = "Professor_id")
    private Professor prof;

    @Column(name = "time")
    private String time;

    // Default constructor
    protected Course() {}

    // Constructor
    public Course(long id, String name, Professor prof, String time) {
        this.id = id;
        this.name = name;
        this.prof = prof;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public Professor getProf() {
        return prof;
    }

    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        if (prof == null) {
            return "Course Name: " + name + ", Prof: N/A, Time: " + time;
        }
        else
            return "Course Name: " + name + ", Prof: " + prof.getFirstName() +
            " " + prof.getLastName() + ", Time: " + time;  
    }
}