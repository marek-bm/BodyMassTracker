package pl.dietician.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
public class BodyMeasurement {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @ManyToOne
    @Getter @Setter
    private Patient patient;

    @Temporal(value = TemporalType.DATE)
    @Getter @Setter
    private Date dateOfInspection;

    @Getter @Setter
    @Positive
    private int heightCm;

    @Getter @Setter
    @Positive
    private double weightKg;

    @Getter @Setter
    @Min(value = 0) @Max(value = 100)
    private double fatPercent;

    @Getter @Setter
    @Positive
    private double fatMassKg;

    @Getter @Setter
    @Min(value = 0) @Max(value = 100)
    private double ffmPercent; //fat free mass

    @Getter @Setter
    @Positive
    private double ffmMassKg;

//    @Positive
    private double BMI;

//    public BodyMeasurement(){
//        this.dateOfInspection=new Date();
//    }

    @Override
    public String toString() {
        return "id=" + id + ",height=" + heightCm + "cm, weight=" + weightKg + "kg"+ "\n"+
                "fat=" + fatPercent + "%, fat mass=" + fatMassKg + "kg"+ "\n"+
                "ffmPercent=" + ffmPercent + ",% ffmMassKg=" + ffmMassKg + ", BMI=" + BMI;
    }
}
