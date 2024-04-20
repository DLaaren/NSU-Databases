package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @Column(length = 8)
    private String sex;

    private int height;

    private int weight;

    private boolean needIsolation;

    private boolean isPregnant;

    private int gestationTerm;

    // default length is 255
    @Column
    private String addInfo;
}
