package com.java10x.CadastroDeNinja.Ninjas.DTO;

import com.java10x.CadastroDeNinja.Missoes.MissoesModel.MissoesModel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
