package nsu.fit.databases.zookeeper.dto;

import lombok.Value;

import java.util.List;

@Value
public class VetCardDto{
    Long id;
    Long animalId;
    String name;
    String sex;
    Integer height;
    Integer weight;
    boolean needIsolation;
    boolean isPregnant;
    Integer gestationTerm;
    String addInfo;
    List<VaccinationHistoryRecordDto> vaccinationHistoryRecords;
    List<MedicalHistoryRecordDto> medicalHistoryRecords;
}
