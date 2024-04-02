package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
// TODO add index by name
// избавиться от аутовайрэд
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
