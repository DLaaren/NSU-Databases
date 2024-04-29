package nsu.fit.databases.zookeeper.dto;

import lombok.Value;

@Value
public class AnimalDto {
    Long id;
    String name;
    Long speciesId;
    Long vetCardId;
    Boolean needWarmCage;
}
