package com.example.demo.models;

import jakarta.persistence.*;


import java.io.Serial;
import java.io.Serializable;

import java.util.Set;

@Entity
@Table(name = "empresa")
public class EmpresaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private int id_empresa;

    @Column(name = "nome_empresa", nullable = false)
    private String nome_empresa;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<UnidadeModel> unidades;

    public int getIdEmpresa() {
        return id_empresa;
    }

    public void setIdEmpresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNomeEmpresa() {
        return nome_empresa;
    }

    public void setNomeEmpresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Set<UnidadeModel> getUnidades() {
        return unidades;
    }

    public void setUnidades(Set<UnidadeModel> unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "EmpresaModel{" +
                "id_empresa=" + id_empresa +
                ", nome_empresa='" + nome_empresa + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", unidades=" + unidades +
                '}';
    }
}

