package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record PlanoRecordDto(@NotNull int idplano,
                             @NotNull @NotBlank  String valorPlano,
                             @NotNull @NotBlank String tipoPlano, Set<Integer> idunidades) {
}
