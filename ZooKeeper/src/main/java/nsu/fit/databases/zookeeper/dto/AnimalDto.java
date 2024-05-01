package nsu.fit.databases.zookeeper.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalDto {
        private Long id;
        private String name;
        private String speciesName;
        private VetCardDto vetCard;
        private Long cageId;
        private Boolean needWarmCage;
}
