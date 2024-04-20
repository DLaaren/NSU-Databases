package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;

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

    private JobTitle jobTitle;
}
