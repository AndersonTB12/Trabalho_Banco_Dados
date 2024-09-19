package com.example.demo.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "aluno")
public class AlunoModel implements Serializable{
    @Serial
    private static final long serialVersionUID = 1l;

    @Id
    private long idaluno;

    private String cpf;
    private String nomealuno;
    private LocalDate datanascimento;
    private String genero;
    private String telefone;
    private String email;
    private String senha;
    private String biometria;
    private int idade;

    @ManyToOne
    @JoinColumn(name = "plano_idplano", referencedColumnName = "idplano")
    private PlanoModel plano;

    public long getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(long idaluno) {
        this.idaluno = idaluno;
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getBiometria() {
        return biometria;
    }

    public void setBiometria(String biometria) {
        this.biometria = biometria;
    }

    public PlanoModel getPlano() {
        return plano;
    }

    public void setPlano(PlanoModel plano_idplano) {
        this.plano = plano_idplano;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
