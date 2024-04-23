package nsu.fit.databases.zookeeper.dto;

import lombok.Value;
import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;

@Value
public class WorkerDto {
    Long id;
    String name;
    Integer salary;
    JobTitle jobTitle;
    String specialization;
}
