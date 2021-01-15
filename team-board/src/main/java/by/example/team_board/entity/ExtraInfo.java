package by.example.team_board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "extra_info")  //lombok
public class ExtraInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "skype")
    private String skype;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Max(value = 150)
    @Column(name = "age")
    private int age;

    @Email(message = "email is not valid")
    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "extraInfo")
    private Person person;
}
