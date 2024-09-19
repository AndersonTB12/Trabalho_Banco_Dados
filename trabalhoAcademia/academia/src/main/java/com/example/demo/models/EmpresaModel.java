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
    private int idEmpresa;
    private String nomeempresa;
    private String cnpj;

    private Set<UnidadeModel> unidades;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeempresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeempresa = nomeEmpresa;
    }

    public String getcnpj() {
        return cnpj;
    }

    public void setcnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Set<UnidadeModel> getUnidades() {
        return unidades;
    }

    public void setUnidades(Set<UnidadeModel> unidades) {
        this.unidades = unidades;
    }
}

