package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UnidadeRecordDto(@NotNull String rua,
                               @NotNull String bairro,
                               @NotNull String cep,
                               @NotNull @NotBlank String telefone_unidade,
                               @NotNull int empresa, @NotNull Set<Integer> planos
                               ) {
}
