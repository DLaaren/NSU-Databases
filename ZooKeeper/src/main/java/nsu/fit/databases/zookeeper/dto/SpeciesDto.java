package nsu.fit.databases.zookeeper.dto;

import nsu.fit.databases.zookeeper.entity.enums.FeedingType;

public record SpeciesDto (
    Long id,
    String speciesName,
    FeedingType feedingType) {
}
