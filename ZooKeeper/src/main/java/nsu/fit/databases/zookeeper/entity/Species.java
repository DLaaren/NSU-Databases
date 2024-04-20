package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.Enums.FeedingType;
import org.hibernate.annotations.NaturalId;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId // unique key allows easier and quicker looking up
    @Column(nullable = false, length = 32)
    private String speciesName;

    private FeedingType feedingType;
}
