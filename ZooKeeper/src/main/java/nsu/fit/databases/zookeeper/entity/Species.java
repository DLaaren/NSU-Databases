package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.Enums.FeedingType;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 32)
    private String speciesName;

    private FeedingType feedingType;
}
