package com.frafael.sensors.temperature.processing.api.model;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
public class TemperatureLogOutput {
    private UUID id;
    private String sensorId;
    private OffsetDateTime registeredAt;
    private Double value;
}
