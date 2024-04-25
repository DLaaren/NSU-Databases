package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;
import nsu.fit.databases.zookeeper.entity.json.Name;
import nsu.fit.databases.zookeeper.entity.json.NameAttributeConverter;
import org.hibernate.annotations.ColumnTransformer;

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

    @Convert(converter = NameAttributeConverter.class)
//    @JdbcTypeCode(SqlTypes.JSON)
    @Column(nullable = false)
    @ColumnTransformer(write = "?::jsonb")
    private Name name;

    private double salary;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
}
