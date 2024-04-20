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
    @Column(nullable = false)
    private Species species;

    // двустороннее отношение между сущностями
    @OneToOne
    private VetCard vetCard;

    @ManyToOne
    @Column(nullable = false)
    private Cage cage;

    private boolean needWarmCage;

    @ManyToMany
    private List<Trainer> trainers;
}
