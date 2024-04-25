package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.*;
import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;
import nsu.fit.databases.zookeeper.entity.json.Name;
import nsu.fit.databases.zookeeper.entity.json.NameAttributeConverter;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
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

//    @Convert(converter = NameAttributeConverter.class)
    @Column(nullable = false)
//    @ColumnTransformer(write = "?::jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private Name name;

    private Double salary;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
}
