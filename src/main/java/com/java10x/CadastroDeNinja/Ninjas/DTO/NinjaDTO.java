package com.java10x.CadastroDeNinja.Ninjas.DTO;

import com.java10x.CadastroDeNinja.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NinjaDTO {

    private Long id;

    private String nome;

    private String email;

    private String aldeia;

    private int idade;

    private MissoesModel missoes;


}
