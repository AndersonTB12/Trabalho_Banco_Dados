package com.example.demo.dtos;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlunoRecordDto(@NotNull String cpf, @NotNull String nome_aluno, @NotNull LocalDate data_nascimento, @NotNull String genero,
                            @NotNull String telefone, @NotNull String email, @NotNull String senha, @NotNull String biometria,
                            @NotNull int idade,
                            int plano) {
}


