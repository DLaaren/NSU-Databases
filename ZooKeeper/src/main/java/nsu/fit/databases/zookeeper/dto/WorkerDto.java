package nsu.fit.databases.zookeeper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nsu.fit.databases.zookeeper.entity.Enums.JobTitle;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkerDto {
    private Long id;
    private String name;
    private Integer salary;
    private JobTitle jobTitle;
    private String specialization;
}
