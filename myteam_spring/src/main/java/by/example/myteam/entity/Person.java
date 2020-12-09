package by.example.myteam.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table("person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

@Column(name = "name")
    private String name;

    @NotBlank
    @Column(name = "login")
    private String login;

    @Size(min = 1, max = 50, message = "Password length from 6 to 50 characters")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="extra_id")
    private ExtraInfo extra;


    public Person() {
    }

    public long getId() {
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

    public ExtraInfo getExtra() {
        return extra;
    }

    public void setExtra(ExtraInfo extra) {
        this.extra = extra;
    }
}
