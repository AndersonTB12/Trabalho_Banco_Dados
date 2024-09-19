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
    @Column(name = "id_plano")
    private int id_plano;

    @Column(name = "valor_plano")
    private String valor_plano;

    @Column(name = "tipo_plano")
    private String tipo_plano;

    @ManyToMany(mappedBy = "planos")
    private Set<UnidadeModel> unidades;

    public int getIdplano() {
        return id_plano;
    }

    public void setIdplano(int id_plano) {
        this.id_plano = id_plano;
    }

    public String getValorplano() {
        return valor_plano;
    }

    public void setValorplano(String valor_plano) {
        this.valor_plano = valor_plano;
    }

    public String getTipoplano() {
        return tipo_plano;
    }

    public void setTipoplano(String tipo_plano) {
        this.tipo_plano = tipo_plano;
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
                "id_plano=" + id_plano +
                ", valor_plano=" + valor_plano +
                ", tipo_plano='" + tipo_plano + '\'' +
                ", unidades=" + unidades +
                '}';
    }
}
