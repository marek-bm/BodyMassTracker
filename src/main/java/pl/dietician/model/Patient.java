package pl.dietician.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.pl.PESEL;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.util.*;

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
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Email
    @Getter @Setter
    private String email;

    @OneToMany
    @Getter @Setter
    private List<BodyMeasurement> bodyMeasurements;

    @ManyToMany (fetch = FetchType.EAGER)
    @Getter @Setter
    private Set<Role> roles;

    public Patient() {
        this.bodyMeasurements=new ArrayList<>();
        this.roles=new HashSet<>();
    }
}
