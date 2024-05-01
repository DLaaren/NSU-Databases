package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nsu.fit.databases.zookeeper.entity.Vet;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VetCardDto {
    Long id;
    Integer age;
    String sex;
    Integer height;
    Integer weight;
    Boolean needIsolation;
    Boolean isPregnant;
    Date gestationTerm;
    String addInfo;
}
