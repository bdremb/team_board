package by.example.myteam.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

@Entity
@Table(name = "extra_info")
public class ExtraInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "skype")
    private String skype;

    @Column(name="city")
    private String city;

    @Column(name="phone_number")
    private String phoneNumber;


    @Max(value = 150)
    @Column(name = "age")
    private int age;

    @Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "extraInfo", cascade = CascadeType.ALL)
    private Person person;

    public ExtraInfo() {
        this.skype = "enter your skype";
        this.city = "enter your city ";
        this.phoneNumber = "enter your phone ";
        this.age = 1;
        this.email = "example@example.com";
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
