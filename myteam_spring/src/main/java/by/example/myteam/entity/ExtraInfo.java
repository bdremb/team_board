package by.example.myteam.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "extra_info")
public class ExtraInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "extra_id")
    private long id;

    @Column(name = "skype")
    private String skype;

    @Min(value = 1)
    @Max(value = 150)
    @Column(name = "age")
    private int age;

    @Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "extra", cascade = CascadeType.ALL)
    private Person person;

    public ExtraInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
