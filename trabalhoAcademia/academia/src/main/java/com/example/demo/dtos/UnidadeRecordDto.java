package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UnidadeRecordDto(@NotNull String rua,
                               @NotNull String bairro,
                               @NotNull String cep,
                               @NotNull int id_empresa,
                               @NotNull @NotBlank String telefoneUnidade
                               ) {
}
