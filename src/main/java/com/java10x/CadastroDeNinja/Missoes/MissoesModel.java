package com.java10x.CadastroDeNinja.Missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java10x.CadastroDeNinja.Ninjas.NinjaModel.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String grauDificuldade;

    // Uma missaão para varios ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;



}
