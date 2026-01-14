package com.phinderuserproject.userproject.dto;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Integer id;
    
    @JsonProperty("Nombre")
    @NotBlank
    private String name;

    @JsonProperty("Paterno")
    @NotBlank
    private String patSurname;

    @JsonProperty("Materno")
    @NotBlank
    private String matSurname;

    @JsonProperty("FechaNacimiento")
    @Past
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @JsonProperty("Genero")
    @NotBlank
    private String gender;

    @JsonProperty("Curp")
    @NotBlank
    private String curp;

    @JsonProperty("Rfc")
    @NotBlank @Size(min = 10, max = 18)
    private String rfc;

    @JsonProperty("Direccion")
    @Valid
    @NotNull
    private DirectionDTO direction;



}
