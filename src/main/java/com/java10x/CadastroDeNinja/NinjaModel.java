package com.java10x.CadastroDeNinja;


import jakarta.persistence.*;

//transforma classe em uma entidade no BD
@Entity
@Table(name = "tb_cadastro_de_ninjas")
public class NinjaModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String aldeia;
    private int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, String aldeia, int idade) {
        this.nome = nome;
        this.email = email;
        this.aldeia = aldeia;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAldeia() {
        return aldeia;
    }

    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
