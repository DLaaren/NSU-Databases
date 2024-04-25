package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "vaccination_history_record")
public class VaccinationHistoryRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "vet_card_id", nullable = false)
    private VetCard vetCard;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, length = 64)
    private String vaccine;
}
