package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalDto {
    private Long id;
    private String name;
    private Long speciesId;
    private Long vetCardId;
    private boolean needWarmCage;
}
