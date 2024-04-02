package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VetCardDto{
    private Long id;
    private Long animalId;
    private String name;
    private String sex;
    private Integer height;
    private Integer weight;
    private boolean needIsolation;
    private boolean isPregnant;
    private Integer gestationTerm;
    private String addInfo;
}
