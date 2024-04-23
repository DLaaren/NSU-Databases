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
@Table(name = "cleaner")
public class Cleaner extends Worker {
    // id will be the same as the id in 'worker' table

    @ManyToMany
    @JoinTable(
            name = "cleaner_cage_relation",
            joinColumns = @JoinColumn(name = "cage_id"),
            inverseJoinColumns = @JoinColumn(name = "cleaner_id")
    )

    private List<Cage> cages;
}
