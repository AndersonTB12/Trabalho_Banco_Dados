package com.example.demo.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "plano")
public class PlanoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idplano;
    private float valorplano;
    private String tipoplano;

    @ManyToMany(mappedBy = "planos")
    private Set<UnidadeModel> unidades;

    public int getIdplano() {
        return idplano;
    }

    public void setIdplano(int idplano) {
        this.idplano = idplano;
    }

    public float getValorplano() {
        return valorplano;
    }

    public void setValorplano(float valorplano) {
        this.valorplano = valorplano;
    }

    public String getTipoplano() {
        return tipoplano;
    }

    public void setTipoplano(String tipoplano) {
        this.tipoplano = tipoplano;
    }

    public Set<UnidadeModel> getUnidades() {
        return unidades;
    }

    public void setUnidades(Set<UnidadeModel> unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "PlanoModel{" +
                "idplano=" + idplano +
                ", valorplano=" + valorplano +
                ", tipoplano='" + tipoplano + '\'' +
                ", unidades=" + unidades +
                '}';
    }
}
