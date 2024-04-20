package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "vet")
public class Vet extends Worker{
    // id will be the same as the id in 'worker' table

    @ManyToMany(mappedBy = "vet_card")
    private List<VetCard> vetCards;

    @Column(length = 64)
    private String specialization;
}
