package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class AnimalDto {
    Long id;
    String name;
    Long speciesId;
    Long vetCardId;
    Boolean needWarmCage;
}
