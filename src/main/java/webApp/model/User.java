package webApp.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
@Valid
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Pattern(regexp="^[a-zA-Z]+$",message="numbers are not allowed to be entered")
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @Column
    @Pattern(regexp="^[a-zA-Z]+$",message="numbers are not allowed to be entered")
    @NotEmpty(message = "lastName should not be empty")
    private  String lastName;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
