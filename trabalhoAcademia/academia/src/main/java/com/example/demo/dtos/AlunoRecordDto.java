package com.example.demo.dtos;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoRecordDto(@NotNull long idaluno, @NotNull String cpf, @NotNull String nomealuno, @NotNull LocalDate datanascimento, @NotNull String genero,
                            @NotNull String telefone, @NotNull String email, @NotNull String senha, @NotNull String biometria,
                            @NotNull int plano,
                            @NotNull int idade) {
}


