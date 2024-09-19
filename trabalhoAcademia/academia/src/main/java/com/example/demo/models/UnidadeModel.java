package com.example.demo.models;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "unidade")
public class UnidadeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idunidade;

    private String rua;
    private String bairro;
    private String cep;
    private String telefoneunidade;

    @ManyToOne
    @JoinColumn(name = "id_empresa", nullable = false)
    private EmpresaModel empresa;

    // Getters e Setters
    public int getIdunidade() {
        return idunidade;
    }

    public void setIdunidade(int idunidade) {
        this.idunidade = idunidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefoneunidade() {
        return telefoneunidade;
    }

    public void setTelefoneunidade(String telefoneunidade) {
        this.telefoneunidade = telefoneunidade;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }
}
