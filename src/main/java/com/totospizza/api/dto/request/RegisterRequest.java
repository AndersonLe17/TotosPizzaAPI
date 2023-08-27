package com.totospizza.api.dto.request;

import com.totospizza.api.dto.PersonDTO;
import com.totospizza.api.entity.enums.Document;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotNull @NotBlank
    @Size(max = 100)
    private String username;
    @NotNull @NotBlank
    @Size(max = 255, min = 6)
    private String password;
    private PersonDTO person;

}
