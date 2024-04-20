package nsu.fit.databases.zookeeper.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Converter
public class NameAttributeConverter implements AttributeConverter<Name, String> {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Name name) {
        try {
            return objectMapper.writeValueAsString(name);
        } catch (JsonProcessingException jpe) {
            log.warn("Cannot convert Address into JSON");
            return null;
        }
    }

    @Override
    public Name convertToEntityAttribute(String s) {
        try {
            return objectMapper.readValue(s, Name.class);
        } catch (JsonProcessingException e) {
            log.warn("Cannot convert JSON into Address");
            return null;
        }
    }
}
