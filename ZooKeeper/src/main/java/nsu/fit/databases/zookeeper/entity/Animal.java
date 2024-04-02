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

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

//    private Cage cage;

    @OneToOne(mappedBy = "animal", cascade = CascadeType.ALL)
    private VetCard vetCard;

//    private Ration ration;

    private boolean needWarmCage;
}
