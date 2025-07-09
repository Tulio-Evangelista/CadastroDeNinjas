package com.java10x.CadastroDeNinja.Missoes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java10x.CadastroDeNinja.Ninjas.NinjaModel.NinjaModel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
