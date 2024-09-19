package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "unidade")
public class UnidadeModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_unidade")
    private int id_unidade;

    @Column(name = "rua")
    private String rua;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "telefone_unidade")
    private String telefone_unidade;

    @ManyToOne
    @JoinColumn(name = "empresa_id_empresa", nullable = false)
    @JsonIgnore
    private EmpresaModel empresa;

    @ManyToMany
    @JoinTable(name = "unidade_oferece_plano",
            joinColumns = @JoinColumn(name = "unidade_id_unidade"),
            inverseJoinColumns = @JoinColumn(name = "plano_id_plano")
    )
    private Set<PlanoModel> planos;

    public int getIdUnidade() {
        return id_unidade;
    }

    public void setIdUnidade(int id_unidade) {
        this.id_unidade = id_unidade;
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

    public String setTelefoneUnidade() {
        return telefone_unidade;
    }

    public void setTelefoneUnidade(String telefone) {
        this.telefone_unidade = telefone;
    }

    public Set<PlanoModel> getPlanos() {
        return planos;
    }

    public void setPlanos(Set<PlanoModel> planos) {
        this.planos = planos;
    }

    public EmpresaModel getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaModel empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "UnidadeModel{" +
                "id=" + id_unidade +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone_unidade + '\'' +
                ", planos=" + planos +
                '}';
    }
}

