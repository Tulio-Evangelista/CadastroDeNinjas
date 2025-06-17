package com.java10x.CadastroDeNinja.Ninjas.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/primeiraRota")
    public String primeiraRota(){
        return "Primeira Rota";
    }

    //adicionar ninja(CREATE)
    @PostMapping("/criarNinja")
    public String criarNinja() {
        return "Ninja criado com sucesso!";
    }

    //procurar ninja por id(CREATE)
    @GetMapping("/procurarNinjaPorId")
    public String procurarNinjaPorId() {
        return "Ninja encontrado com sucesso!";
    }

    //mostrar todos os ninjas(READ)
    @GetMapping("/mostrarTodosNinjas")
    public String mostrarTodosNinjas() {
        return "Lista de todos os ninjas";
    }

    //alterar dados do ninja(UPDATE)
    @PostMapping("/alterarNinja")
    public String alterarNinja() {
        return "Ninja alterado com sucesso!";
    }

    //deletar ninja por id(DELETE)
    @DeleteMapping("/deletarNinja")
    public String deletarNinja() {
        return "Ninja deletado com sucesso!";
    }





}
