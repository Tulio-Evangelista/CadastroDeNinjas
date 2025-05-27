package com.java10x.CadastroDeNinja.Ninjas.NinjaModel;


import com.java10x.CadastroDeNinja.Missoes.MissoesModel.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//transforma classe em uma entidade no BD
@Entity
@Table(name = "tb_cadastro_de_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String aldeia;
    private int idade;

    //uma unica missao para cada ninja
    @ManyToOne
    @JoinColumn(name = "missoes_id")// forein Key ou chave estrangeira
    private MissoesModel missoes;




}
