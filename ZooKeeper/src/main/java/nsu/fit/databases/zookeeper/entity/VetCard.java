package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vet_card")
public class VetCard {
    @Id
    private long id;

    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
    @MapsId
    private Animal animal;

    @Column(nullable = false, columnDefinition = "INT CHECK (age >= 0)")
    private int age;

    @Column(length = 8)
    private String sex;

    @Column(columnDefinition = "NUMERIC CHECK (height > 0)")
    private double height;

    @Column(columnDefinition = "NUMERIC CHECK (weight > 0)")
    private double weight;

    private boolean needIsolation;

    private boolean isPregnant;

    private Date gestationTerm;

    // default length is 255
    @Column
    private String addInfo;
}
