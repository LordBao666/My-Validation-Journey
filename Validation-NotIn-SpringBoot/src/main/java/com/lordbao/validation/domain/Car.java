package com.lordbao.validation.domain;

import com.lordbao.validation.validations.constants.CaseMode;
import com.lordbao.validation.validations.constraints.CheckCase;
import com.lordbao.validation.validations.constraints.ValidLicensePlate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    @NotNull
    private String manufacturer;

//    @NotNull
//    @Size(min = 2, max = 14)
//    @CheckCase(CaseMode.UPPER)
    @ValidLicensePlate
    private String licensePlate;



    @Min(2)
    private int seatCount;

    @NotNull
    @Valid
    private Person driver;



}