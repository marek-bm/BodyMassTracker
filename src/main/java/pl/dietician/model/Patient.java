package pl.dietician.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @NotNull
    @Getter @Setter
    private String name;

    @NotNull
    @Getter @Setter
    private String lastName;

    @PESEL
    @Getter @Setter
    private String pesel;

    @Past
    @Getter @Setter
    private int yearOfBirth;

    @OneToMany
    @Getter @Setter
    private List<BodyMeasurement> bodyMeasurements;

    @Positive
    private double BMI;


}
