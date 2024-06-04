package com.bhagya.learning.crud.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartsInput {

    private int featureId;

    @NotNull(message = "nameEn should not be null")
    private String nameEn;

    @NotNull(message = "nameDE should not be null")
    private String nameDE;

    @NotNull(message = "partNumber should not be null")
    @Size(min = 11, max = 11, message = "partNumber must have 11 characters")
    private String partNumber;

    @NotNull(message = "noOfDS should not be null")
    private int noOfDS;

    @NotNull(message = "noOfDZ should not be null")
    private int noOfDZ;
}
