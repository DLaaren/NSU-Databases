package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

enum FeedingType {
    CARNIVORE,
    HERBIVORE,
    OMNIVORE,
    INSECTIVORE
}

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "species_name", nullable = false)
    private String speciesName;

    @Column(name = "feeding")
    private FeedingType feeding;
}
