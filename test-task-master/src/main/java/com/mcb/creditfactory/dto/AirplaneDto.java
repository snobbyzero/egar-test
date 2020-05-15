package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.model.AirplaneValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral{
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private Integer fuelCapacity;
    private Integer seats;

    private List<AirplaneValues> values;

    public BigDecimal getValue() {
        return this.values.stream().max((a, b) -> a.getDate().isAfter(b.getDate()) ? 1 : -1).get().getValue();
    }

    public LocalDate getDate() {
        return this.values.stream().max((a, b) -> a.getDate().isAfter(b.getDate()) ? 1 : -1).get().getDate();
    }
}
