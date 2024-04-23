package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 16)
    private String name;

    @ManyToOne
    @JoinColumn(name = "species_id", nullable = false)
    private Species species;

    // двустороннее отношение между сущностями
    @OneToOne
    @JoinColumn(name = "vet_card_id", nullable = false)
    private VetCard vetCard;

    @ManyToOne
    @JoinColumn(name = "cage_id", nullable = false)
//    @Column(nullable = false)
    private Cage cage;

    private boolean needWarmCage;

    @ManyToMany
    @JoinTable(
            name = "animal_trainer_relation",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "animal_id")
    )
    private List<Trainer> trainers;
}
