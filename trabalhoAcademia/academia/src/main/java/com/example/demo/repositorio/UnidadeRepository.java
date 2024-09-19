package com.example.demo.repositorio;

import com.example.demo.models.UnidadeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<UnidadeModel, Integer> {
}
