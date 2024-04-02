package nsu.fit.databases.zookeeper.dto;

import nsu.fit.databases.zookeeper.entity.JobTitle;

public record UserDto(Long id, String name, int salary, JobTitle jobTitle, String specialization) {}
