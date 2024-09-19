package com.example.demo.controllers;

import com.example.demo.dtos.AlunoRecordDto;
import com.example.demo.dtos.UnidadeRecordDto;
import com.example.demo.models.AlunoModel;
import com.example.demo.models.EmpresaModel;
import com.example.demo.models.PlanoModel;
import com.example.demo.models.UnidadeModel;
import com.example.demo.repositorio.AlunoRepository;
import com.example.demo.repositorio.EmpresaRepository;
import com.example.demo.repositorio.PlanoRepository;
import com.example.demo.repositorio.UnidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UnidadeController {

    @Autowired
    UnidadeRepository unidadeRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping("/academia/unidade")
    public ResponseEntity<UnidadeModel> saveUnidade(@RequestBody @Valid UnidadeRecordDto unidadeRecordDto) {
        Optional<EmpresaModel> empresaOptional = empresaRepository.findById(unidadeRecordDto.id_empresa());

        if (empresaOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        var unidadeModel = new UnidadeModel();
        BeanUtils.copyProperties(unidadeRecordDto, unidadeModel);

        //unidadeModel.setEmpresa(empresaOptional.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeRepository.save(unidadeModel));
    }

    @GetMapping("/academia/unidade")
    public ResponseEntity<List<UnidadeModel>> getAllUnidades(){
        return ResponseEntity.status(HttpStatus.OK).body(unidadeRepository.findAll());
    }

    @GetMapping("/academia/unidade/{id}")
    public ResponseEntity<Object> getOneUnidade(@PathVariable(value="id") int id){
        Optional<UnidadeModel> unidadeO = unidadeRepository.findById(id);
        if(unidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade não encontrata.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(unidadeO.get());
    }

    @PutMapping("/academia/unidade/{id}")
    public ResponseEntity<Object> updateUnidade(@PathVariable(value="id") int id,
                                                @RequestBody @Valid UnidadeRecordDto unidadeRecordDto) {
        Optional<UnidadeModel> unidadeO = unidadeRepository.findById(id);
        if(unidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade não encontrada.");
        }
        var unidadeModel = unidadeO.get();
        BeanUtils.copyProperties(unidadeRecordDto, unidadeModel, "id");
        return ResponseEntity.status(HttpStatus.OK).body(unidadeRepository.save(unidadeModel));
    }

    @DeleteMapping("/academia/unidade/{id}")
    public ResponseEntity<Object> deleteUnidade(@PathVariable(value="id") int id) {
        Optional<UnidadeModel> unidadeO = unidadeRepository.findById(id);
        if(unidadeO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unidade não encontrada");
        }
        unidadeRepository.delete(unidadeO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Unidade deletada com sucesso.");
    }
}