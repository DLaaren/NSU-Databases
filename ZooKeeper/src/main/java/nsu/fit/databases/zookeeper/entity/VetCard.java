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
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

//    @Column(name = "animal_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Animal animal;

    @Column(name = "sex")
    private String sex;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "need_isolation")
    private boolean needIsolation;

    @Column(name = "is_pregnant")
    private boolean isPregnant;

    @Column(name = "gestation_term")
    private int gestationTerm;

    @Column(name = "add_info")
    private String addInfo;
}
