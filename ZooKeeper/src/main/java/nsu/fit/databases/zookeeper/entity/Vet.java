package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
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

    @ManyToMany
    @JoinTable(
            name = "vet_vet_card_relation",
            joinColumns = @JoinColumn(name = "vet_card_id"),
            inverseJoinColumns = @JoinColumn(name = "vet_id")
    )
    private List<VetCard> vetCards;

    @Column(length = 64)
    private String specialization;
}
