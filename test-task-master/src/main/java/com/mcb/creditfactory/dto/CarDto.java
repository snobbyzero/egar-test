package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.model.CarValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("car")
public class CarDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private Double power;
    private Short year;

    private List<CarValues> values;

    public BigDecimal getValue() {
        return this.values.stream().max((a, b) -> a.getDate().isAfter(b.getDate()) ? 1 : -1).get().getValue();
    }

    public LocalDate getDate() {
        return this.values.stream().max((a, b) -> a.getDate().isAfter(b.getDate()) ? 1 : -1).get().getDate();
    }
}
