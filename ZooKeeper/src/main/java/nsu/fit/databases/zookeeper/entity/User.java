package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

enum JobTitle {
    ADMINISTRATIVE_WORKER,
    VETERINARIAN,
    TRAINER,
    CLEANER,
    HANDY_WORKER
}

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary")
    private int salary;

    @Column(name = "jobTitle")
    private JobTitle jobTitle;

    @Column(name = "specialization")
    private String specialization;

}
