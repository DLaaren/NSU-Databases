package nsu.fit.databases.zookeeper.dto;

import nsu.fit.databases.zookeeper.entity.enums.JobTitle;

public record WorkerDto (
    Long id,
    String name,
    Integer age,
    Integer salary,
    JobTitle jobTitle) {
}
