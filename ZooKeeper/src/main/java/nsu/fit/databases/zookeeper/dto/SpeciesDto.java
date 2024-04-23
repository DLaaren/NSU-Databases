package nsu.fit.databases.zookeeper.dto;

import lombok.Value;
import nsu.fit.databases.zookeeper.entity.Enums.FeedingType;

@Value
public class SpeciesDto {
    Long id;
    String speciesName;
    FeedingType feedingType;
}
