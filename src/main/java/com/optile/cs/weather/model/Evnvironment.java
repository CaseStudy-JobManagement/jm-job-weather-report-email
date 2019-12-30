package com.optile.cs.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Evnvironment {
    private Double temperature;
    private Double pressure;
    private Integer humidity;
}
