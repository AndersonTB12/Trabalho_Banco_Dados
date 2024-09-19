package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EmpresaRecordDto(@NotNull @NotBlank String nome_empresa,
                               @NotNull @NotBlank String cnpj
) {
}