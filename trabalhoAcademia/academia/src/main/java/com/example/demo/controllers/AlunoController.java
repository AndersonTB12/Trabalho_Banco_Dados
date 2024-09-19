package com.example.demo.controllers;

import com.example.demo.models.AlunoModel;
import com.example.demo.models.PlanoModel;
import com.example.demo.dtos.AlunoRecordDto;
import com.example.demo.repositorio.AlunoRepository;
import com.example.demo.repositorio.PlanoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoController {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    PlanoRepository planoRepository;

    @PostMapping("/academia/alunos")
    public ResponseEntity<AlunoModel> saveAluno(@RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        Optional<PlanoModel> planoOptional = planoRepository.findById(alunoRecordDto.plano());

        if (planoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        var aluno = new AlunoModel();
        aluno.setCpf(alunoRecordDto.cpf());
        aluno.setNomeAluno(alunoRecordDto.nome_aluno());
        aluno.setDataNascimento(alunoRecordDto.data_nascimento());
        aluno.setGenero(alunoRecordDto.genero());
        aluno.setTelefone(alunoRecordDto.telefone());
        aluno.setEmail(alunoRecordDto.email());
        aluno.setSenha(alunoRecordDto.senha());
        aluno.setBiometria(alunoRecordDto.biometria());
        aluno.setIdade(alunoRecordDto.idade());

        aluno.setPlano(planoOptional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepository.save(aluno));
    }

    @GetMapping("/academia/alunos")
    public ResponseEntity<List<AlunoModel>> getAllAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
    }

    @GetMapping("/academia/alunos/{id}")
    public ResponseEntity<Object> getOneAluno(@PathVariable(value="id") int id) {
        Optional<AlunoModel> alunoO = alunoRepository.findById(id);
        if (alunoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(alunoO.get());
    }

    @PutMapping("/academia/alunos/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value="id") int id,
                                              @RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        Optional<AlunoModel> alunoO = alunoRepository.findById(id);
        if (alunoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        var aluno = alunoO.get();
        BeanUtils.copyProperties(alunoRecordDto, aluno);
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.save(aluno));
    }

    @DeleteMapping("/academia/alunos/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable(value="id") int id) {
        Optional<AlunoModel> alunoO = alunoRepository.findById(id);
        if (alunoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        alunoRepository.delete(alunoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
    }
}

