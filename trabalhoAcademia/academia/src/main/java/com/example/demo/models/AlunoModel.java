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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private int id_aluno;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "nome_aluno", nullable = false)
    private String nome_aluno;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "biometria", nullable = false)
    private String biometria;

    @Column(name = "idade", nullable = false)
    private int idade;

    @ManyToOne
    @JoinColumn(name = "plano_id_plano", referencedColumnName = "id_plano")
    private PlanoModel plano;

    public int getIdAluno() {
        return id_aluno;
    }

    public void setIdAluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNomeAluno() {
        return nome_aluno;
    }

    public void setNomeAluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    @Override
    public String toString() {
        return "AlunoModel{" +
                "id_aluno=" + id_aluno +
                ", cpf='" + cpf + '\'' +
                ", nome_aluno='" + nome_aluno + '\'' +
                ", data_nascimento=" + data_nascimento +
                ", genero='" + genero + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", biometria='" + biometria + '\'' +
                ", idade=" + idade +
                ", plano=" + plano +
                '}';
    }
}
