package nsu.fit.databases.zookeeper.dto;

import lombok.Value;

import java.sql.Date;

@Value
public class VaccinationHistoryRecordDto {
    Long id;
    Long vetCardId;
    Date date;
    String vaccination;
}
