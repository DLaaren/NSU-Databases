package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nsu.fit.databases.zookeeper.entity.FeedingType;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpeciesDto {
    private Long id;
    private String speciesName;
    private FeedingType feedingType;
}
