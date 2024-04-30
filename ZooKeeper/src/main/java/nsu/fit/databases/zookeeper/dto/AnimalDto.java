package nsu.fit.databases.zookeeper.dto;

import lombok.*;
import nsu.fit.databases.zookeeper.entity.Trainer;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalDto {
        private Long id;
        private String name;
        private Long speciesId;
        private Long vetCardId;
        private Long cageId;
        private Boolean needWarmCage;
}
