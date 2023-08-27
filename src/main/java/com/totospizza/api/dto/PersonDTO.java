package com.totospizza.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.totospizza.api.entity.enums.Document;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    @NotNull @NotBlank
    @Size(max = 100)
    private String name;
    @NotNull @NotBlank
    @Size(max = 100)
    private String lastname;
    @NotNull @NotBlank
    private Document document;
    @NotNull @NotBlank
    @Size(max = 12, min = 8)
    private String documentNumber;
    @NotNull @NotBlank @Email
    @Size(max = 255)
    private String email;
    @NotNull @NotBlank
    @Size(max = 15)
    private String phone;
    @JsonFormat(pattern = "dd-MM-yyyy", locale = "es-PE", timezone = "America/Lima")
    @Past
    private Date birthdate;
    @NotNull @NotBlank
    @Size(max = 15)
    private String gender;
}
