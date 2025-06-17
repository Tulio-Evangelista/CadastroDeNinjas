package com.java10x.CadastroDeNinja.Missoes.MissoesController;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("missoes/")
public class MissoesController {


    @PostMapping("/criarMissao")
    public String criarMissao() {
        return "Missão criada com sucesso!";
    };



    @GetMapping("/mostrarTodasMissoes")
    public String mostrarTodasMissoes() {
        return "Lista de todas as missões";
    };


    @DeleteMapping("/deletarMissao")
    public String deletarMissao() {
        return "Missão deletada com sucesso!";
    };


}
