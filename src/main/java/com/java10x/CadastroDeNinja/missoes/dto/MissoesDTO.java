package com.java10x.CadastroDeNinja.missoes.dto;

import com.java10x.CadastroDeNinja.ninjas.ninjaModel.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MissoesDTO {

    private Long id;

    private String nome;

    private String grauDificuldade;


    private List<NinjaModel> ninjas;
}
