package nsu.fit.databases.zookeeper.dto;

import nsu.fit.databases.zookeeper.entity.Vet;

import java.sql.Date;
import java.util.List;

public record VetCardDto (
    Long id,
    Integer age,
    String sex,
    Integer height,
    Integer weight,
    Boolean needIsolation,
    Boolean isPregnant,
    Date gestationTerm,
    String addInfo,
    List<Vet> vets) {
}
