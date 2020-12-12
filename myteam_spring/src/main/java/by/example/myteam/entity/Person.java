package by.example.myteam.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Укажите Ваше имя")
    private String name;

    @Column(name="surname")
    @NotBlank(message = "Укажите Вашу фамилию")
    private String surname;

    @NotBlank(message = "Придумайте логин")
    @Column(name = "login")
    private String login;

    @Column(name = "gender")
    private String gender;


    @Size(min = 1, max = 50, message = "Password length from 6 to 50 characters")
    @Column(name = "password")
    private String password;

    @Transient
    @NotBlank(message = "подтвердите пароль")
    private String confirmPassword;


    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
