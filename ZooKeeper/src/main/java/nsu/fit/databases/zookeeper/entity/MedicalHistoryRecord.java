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
@Table(name = "medical_history_record")
public class MedicalHistoryRecord {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "vet_card_id", nullable = false)
    private VetCard vetCard;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, length = 64)
    private String disease;

    // default length is 255
    private String treatment;
}
