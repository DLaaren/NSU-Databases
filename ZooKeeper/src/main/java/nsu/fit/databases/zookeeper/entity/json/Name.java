package nsu.fit.databases.zookeeper.entity.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Name {
    private String firstName;
    private String middleName;
    private String secondName;
    private String patronymicName;
}
