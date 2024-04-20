package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vaccination_history_record")
public class VaccinationHistoryRecord {
    @Id
    private long id;

    @ManyToOne
    @Column(nullable = false)
    private VetCard vetCard;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, length = 64)
    private String vaccination;
}
