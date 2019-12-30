package com.optile.cs.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.omg.CORBA.Environment;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private Environment environment;
}
