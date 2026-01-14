package com.phinderuserproject.userproject.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class DirectionDTO {

    @JsonProperty("Calle")
    @NotBlank
    private String street;

    @JsonProperty("NumInt")
    @NotNull
    private Integer intNum;

    @JsonProperty("NumExt")
    @NotNull
    private Integer extNum;

    @JsonProperty("Colonia")
    @NotBlank
    private String suburb;

    @JsonProperty("CP")
    @NotBlank
    private String zipCode;

    @JsonProperty("Municipio")
    @NotBlank
    private String municipality;

    @JsonProperty("Estado")
    @NotBlank
    private String state;


}
