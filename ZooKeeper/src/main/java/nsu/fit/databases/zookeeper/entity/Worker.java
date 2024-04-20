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

    @Column(nullable = false, length = 32)
    private String name;

    private Integer salary;

    private JobTitle jobTitle;
}
