package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;


/*
 * Base class of User entity
 */
@MappedSuperclass
public class User implements Serializable{
    @Id
    private long uid;

    @Column(name = "firstName")
    @NotEmpty
    private String firstName;
    
    @Column(name = "lastName")
    @NotEmpty
    private String lastName;

    public User() {}

    public User(long id, String firstName, String lastName) {
        this.uid = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUid() {
        return uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUid(long id) {
        this.uid = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}