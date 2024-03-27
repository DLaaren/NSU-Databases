package nsu.fit.databases.zookeeper.animals;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "animal")
public class Animal {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "species_id", nullable = false)
    private long speciesId;

    @Column(name = "cage_id", nullable = false)
    private long cageId;

    @Column(name = "vet_card_id", unique = true, nullable = false)
    private long vetCardId;

    @Column(name = "ration_id", nullable = false)
    private long rationId;

    @Column(name = "need_warm_cage")
    private boolean needWarmCage;
}
