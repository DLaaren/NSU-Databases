package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nsu.fit.databases.zookeeper.entity.enums.FeedingType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpeciesDto {
    Long id;
    String speciesName;
    FeedingType feedingType;
}
