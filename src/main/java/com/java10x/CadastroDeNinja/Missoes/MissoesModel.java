package com.java10x.CadastroDeNinja.Missoes;


import com.java10x.CadastroDeNinja.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String grauDificuldade;

    // Uma missaão para varios ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;


    public MissoesModel() {
    }

    public MissoesModel(Long id, String nome, String grauDificuldade, List<NinjaModel> ninjas) {
        this.id = id;
        this.nome = nome;
        this.grauDificuldade = grauDificuldade;
        this.ninjas = ninjas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NinjaModel> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<NinjaModel> ninjas) {
        this.ninjas = ninjas;
    }

    public String getGrauDificuldade() {
        return grauDificuldade;
    }

    public void setGrauDificuldade(String grauDificuldade) {
        this.grauDificuldade = grauDificuldade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
