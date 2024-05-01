package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nsu.fit.databases.zookeeper.entity.enums.JobTitle;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkerDto {
    Long id;
    String name;
    Integer age;
    Integer salary;
    JobTitle jobTitle;
}
