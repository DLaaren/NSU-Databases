package nsu.fit.databases.zookeeper.dto;

import lombok.Value;

import java.sql.Date;

@Value
public class MedicalHistoryRecordDto {
    Long id;
    Long vetCardId;
    Date date;
    String disease;
    String treatment;
}
