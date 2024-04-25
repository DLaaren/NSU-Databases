package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vet_card")
public class VetCard {
    @Id
    private long id;

    // animal_id (PK) ------- vet_card_id (PK)(FK) = animal_id

    @OneToOne
    @MapsId
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    @Column(columnDefinition = "INT CHECK (age >= 0)")
    private int age;

    @Column(length = 8)
    private String sex;

    @Column(columnDefinition = "NUMERIC CHECK (height > 0)")
    private Double height;

    @Column(columnDefinition = "NUMERIC CHECK (weight > 0)")
    private Double weight;

    private Boolean needIsolation;

    @Column(columnDefinition = "BOOLEAN CHECK (NOT(is_pregnant = TRUE and sex = 'male'))")
    private Boolean isPregnant;

    @Column(columnDefinition = "DATE CHECK (is_pregnant = TRUE)")
    private Date gestationTerm;

    // default length is 255
    private String addInfo;

    @ManyToMany(mappedBy = "vetCards")
    private List<Vet> vets;
}
