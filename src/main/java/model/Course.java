package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Course implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotEmpty
    private String name;

    @Column(name = "prof")
    @NotEmpty
    private long profId;

    @Column(name = "time")
    private String time;

    // Default constructor
    protected Course() {}

    // Constructor
    public Course(String name, long profId, String time) {
        this.name = name;
        this.profId = profId;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public long getProfId() {
        return profId;
    }

    public String getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfId(long profId) {
        this.profId = profId;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Course Name: " + name + ", Prof ID: " + profId +
            ", Time: " + time;  
    }
}