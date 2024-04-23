package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cage")
public class Cage {
    @Id
    // we do not generate its value 'cause we want to set out own
    private long id;

    @ManyToMany(mappedBy = "cages")
    private List<Cleaner> cleaners;
}