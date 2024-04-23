package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;
import nsu.fit.databases.zookeeper.entity.json.Name;
import nsu.fit.databases.zookeeper.entity.json.NameAttributeConverter;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "worker")
@Inheritance(strategy = InheritanceType.JOINED)
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Convert(converter = NameAttributeConverter.class)
    @Column(nullable = false)
    private Name name;

    private Integer salary;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
}
