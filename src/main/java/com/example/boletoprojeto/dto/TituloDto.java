package com.example.boletoprojeto.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data

public class TituloDto {

    @NotBlank
    @Size(max = 15)
    private String CPF;

    @NotBlank
    private String nomeSacado;

    @NotBlank
    private String razaoSocialSacador;

    @NotBlank
    @Size(max = 12)
    private String nossoNumero;

    @NotBlank
    @Size(max = 15)
    private String seuNumero;

    @NotBlank
    @Size(max = 15)
    private LocalDateTime registrationDate;

}
