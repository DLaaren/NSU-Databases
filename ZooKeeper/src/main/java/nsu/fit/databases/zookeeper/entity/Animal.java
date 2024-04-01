package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

//    @Column(name = "species_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "species_id")
    private Species species;

    @Column(name = "cage_id", nullable = false)
    private long cageId;

//    @Column(name = "vet_card_id", unique = true, nullable = false)
    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
//    @MapsId
    private VetCard vetCard;

    @Column(name = "ration_id", nullable = false)
    private long rationId;

    @Column(name = "need_warm_cage")
    private boolean needWarmCage;
}
