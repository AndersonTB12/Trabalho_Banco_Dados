package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record PlanoRecordDto(@NotNull @NotBlank  String valor_plano,
                             @NotNull @NotBlank String tipo_plano
                             ) {
}
//Set<Integer> id_unidades

