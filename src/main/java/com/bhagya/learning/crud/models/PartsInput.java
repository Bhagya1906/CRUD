package com.bhagya.learning.crud.models;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartsInput {

    @NotNull
    private int featureId;

    @NotEmpty(message = "nameEn should not be empty")
    @Size(min = 2, message = "nameEn should have at least 2 characters")
    private String nameEn;

    @NotBlank(message = "nameDE should not be empty")
    @Size(min = 2, message = "nameDE should have at least 2 characters")
    private String nameDE;

    @NotBlank(message = "partNumber should not be empty")
    @Size(min = 11, message = "partNumber should have at least 11 characters")
    private String partNumber;

    @NotNull
    @Positive
    private int noOfDS;

    @NotNull
    @Positive
    private int noOfDZ;
}
