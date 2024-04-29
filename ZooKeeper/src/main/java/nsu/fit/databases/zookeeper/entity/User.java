package nsu.fit.databases.zookeeper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nsu.fit.databases.zookeeper.entity.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
