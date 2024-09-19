package com.example.demo.controllers;

import com.example.demo.dtos.EmpresaRecordDto;
import com.example.demo.models.EmpresaModel;
import com.example.demo.repositorio.EmpresaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping("/academia/empresa")
    public ResponseEntity<EmpresaModel> saveEmpresa(@RequestBody @Valid EmpresaRecordDto empresaRecordDto) {
        var empresaModel = new EmpresaModel();
        BeanUtils.copyProperties(empresaRecordDto, empresaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresaModel));
    }

    @GetMapping("/academia/empresa")
    public ResponseEntity<List<EmpresaModel>> getAllEmpresas(){
        return ResponseEntity.status(HttpStatus.OK).body(empresaRepository.findAll());
    }

    @GetMapping("/academia/empresa/{id}")
    public ResponseEntity<Object> getOneEmpresa(@PathVariable(value="id") int id){
        Optional<EmpresaModel> empresaO = empresaRepository.findById(id);
        if(empresaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrata.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(empresaO.get());
    }

    @PutMapping("/academia/empresa/{id}")
    public ResponseEntity<Object> updateEmpresa(@PathVariable(value="id") int id,
                                                @RequestBody @Valid EmpresaRecordDto empresaRecordDto) {
        Optional<EmpresaModel> empresaO = empresaRepository.findById(id);
        if(empresaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada.");
        }
        var empresaModel = empresaO.get();
        BeanUtils.copyProperties(empresaRecordDto, empresaModel, "id");
        return ResponseEntity.status(HttpStatus.OK).body(empresaRepository.save(empresaModel));
    }

    @DeleteMapping("/academia/empresa/{id}")
    public ResponseEntity<Object> deleteEmpresa(@PathVariable(value="id") int id) {
        Optional<EmpresaModel> empresaO = empresaRepository.findById(id);
        if(empresaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada");
        }
        empresaRepository.delete(empresaO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Empresa deletada com sucesso.");
    }
}

