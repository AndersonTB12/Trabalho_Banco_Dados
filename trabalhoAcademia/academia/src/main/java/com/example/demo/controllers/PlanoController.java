package com.example.demo.controllers;

import com.example.demo.dtos.PlanoRecordDto;
import com.example.demo.models.PlanoModel;
import com.example.demo.models.UnidadeModel;
import com.example.demo.repositorio.PlanoRepository;
import com.example.demo.repositorio.UnidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class PlanoController {

    @Autowired
    PlanoRepository planoRepository;

    @Autowired
    UnidadeRepository unidadeRepository;

    /*@PostMapping("/academia/plano")
    public ResponseEntity<PlanoModel> savePlano(@RequestBody @Valid PlanoRecordDto planoRecordDto) {
        var planoModel = new PlanoModel();
        BeanUtils.copyProperties(planoRecordDto, planoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(planoRepositorio.save(planoModel));
    }*/

    @PostMapping("/academia/plano")
    public ResponseEntity<PlanoModel> savePlano(@RequestBody @Valid PlanoRecordDto planoRecordDto) {

        var planoModel = new PlanoModel();
        BeanUtils.copyProperties(planoRecordDto, planoModel);

        Set<UnidadeModel> unidades = new HashSet<>();
        for (int idunidade : planoRecordDto.idunidades()) {
            Optional<UnidadeModel> unidadeOptional = unidadeRepository.findById(idunidade);
            unidadeOptional.ifPresent(unidades::add);
        }

        planoModel.setUnidades(unidades);

        return ResponseEntity.status(HttpStatus.CREATED).body(planoRepository.save(planoModel));
    }

    @GetMapping("/academia/plano")
    public ResponseEntity<List<PlanoModel>> getAllPlanos(){
        return ResponseEntity.status(HttpStatus.OK).body(planoRepository.findAll());
    }

    @GetMapping("/academia/plano/{id}")
    public ResponseEntity<Object> getOnePlano(@PathVariable(value="id") int id){
        Optional<PlanoModel> planoO = planoRepository.findById(id);
        if(planoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plano não encontrata.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(planoO.get());
    }

    @PutMapping("/academia/plano/{id}")
    public ResponseEntity<Object> updatePlano(@PathVariable(value="id") int id,
                                              @RequestBody @Valid PlanoRecordDto planoRecordDto) {
        Optional<PlanoModel> planoO = planoRepository.findById(id);
        if(planoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plano não encontrada.");
        }
        var planoModel = planoO.get();
        BeanUtils.copyProperties(planoRecordDto, planoModel, "id");
        return ResponseEntity.status(HttpStatus.OK).body(planoRepository.save(planoModel));
    }

    @DeleteMapping("/academia/plano/{id}")
    public ResponseEntity<Object> deletePlano(@PathVariable(value="id") int id) {
        Optional<PlanoModel> planoO = planoRepository.findById(id);
        if(planoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plano não encontrado");
        }
        planoRepository.delete(planoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Plano deletado com sucesso.");
    }
}

