package by.example.team_board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "enter your name")
    private String name;

    @Column(name = "surname")
    @NotBlank(message = "enter your surname")
    private String surname;

    @NotBlank(message = "enter login")
    @Column(name = "login")
    private String login;

    @Column(name = "gender")
    private String gender;

    @Size(min = 2, max = 50, message = "password length must be from 2 to 50 characters")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)  //static import
    @JoinColumn(name = "extra_info_id")
    private ExtraInfo extraInfo;
}
