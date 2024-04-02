package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vet_card")
public class VetCard {

    @Id
    private long id;

    @OneToOne
    @MapsId
    private Animal animal;

    private String sex;

    private int height;

    private int weight;

    private boolean needIsolation;

    private boolean isPregnant;

    private int gestationTerm;

    private String addInfo;
}
