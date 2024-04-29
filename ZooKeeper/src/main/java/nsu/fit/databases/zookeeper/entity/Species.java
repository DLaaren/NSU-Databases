package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.enums.FeedingType;
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

    @NaturalId // immutable unique key allows easier and quicker looking up --> index
    @Column(nullable = false, length = 32)
    private String speciesName;

    @Enumerated(EnumType.STRING)
    private FeedingType feedingType;
}
