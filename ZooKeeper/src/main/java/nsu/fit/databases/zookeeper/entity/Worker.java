package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.enums.JobTitle;
import nsu.fit.databases.zookeeper.entity.json.Name;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "worker")
@Inheritance(strategy = InheritanceType.JOINED)
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Name name;

    @Column(nullable = false)
    private Integer age;

    private Double salary;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
}
