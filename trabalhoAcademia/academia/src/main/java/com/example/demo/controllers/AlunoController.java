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
    AlunoRepository alunoRepositorio;

    @Autowired
    PlanoRepository planoRepositorio;

    @PostMapping("/academia/alunos")
    public ResponseEntity<AlunoModel> saveAluno(@RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        Optional<PlanoModel> planoOptional = planoRepositorio.findById(alunoRecordDto.plano());

        if (planoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        var aluno = new AlunoModel();
        BeanUtils.copyProperties(alunoRecordDto, aluno);

        aluno.setPlano(planoOptional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepositorio.save(aluno));
    }

    /*
    @PostMapping("/alunos")
    public ResponseEntity<Aluno> saveAluno(@RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        var aluno = new Aluno();
        BeanUtils.copyProperties(alunoRecordDto, aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoRepositorio.save(aluno));
    }
    */

    @GetMapping("/academia/alunos")
    public ResponseEntity<List<AlunoModel>> getAllAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepositorio.findAll());
    }

    @GetMapping("/academia/alunos/{id}")
    public ResponseEntity<Object> getOneAluno(@PathVariable(value="id") long idaluno) {
        Optional<AlunoModel> aluno1 = alunoRepositorio.findById(idaluno);
        if (aluno1.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluno1.get());
    }

    @PutMapping("/academia/alunos/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable(value="id") long idaluno,
                                              @RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        Optional<AlunoModel> aluno1 = alunoRepositorio.findById(idaluno);
        if (aluno1.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        var aluno = aluno1.get();
        BeanUtils.copyProperties(alunoRecordDto, aluno);
        return ResponseEntity.status(HttpStatus.OK).body(alunoRepositorio.save(aluno));
    }

    @DeleteMapping("/academia/alunos/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable(value="id") long idaluno) {
        Optional<AlunoModel> aluno1 = alunoRepositorio.findById(idaluno);
        if (aluno1.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        alunoRepositorio.delete(aluno1.get());
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso");
    }
}

