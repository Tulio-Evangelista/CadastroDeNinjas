package com.java10x.CadastroDeNinja.Ninjas.Controller;

import com.java10x.CadastroDeNinja.Ninjas.NinjaModel.NinjaModel;
import com.java10x.CadastroDeNinja.Ninjas.NinjaService.NinjaService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ninjas/")
public class NinjaController {



    private NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/primeiraRota")
    public String primeiraRota(){
        return "Primeira Rota";
    }

    //adicionar ninja(CREATE)
    @PostMapping("/criarNinja")
    public NinjaModel criarNinja() {
        return  ninjaService.criarNinja(new NinjaModel());
    }

    //procurar ninja por id(CREATE)
    @GetMapping("/procurarNinjaPorId")
    public String procurarNinjaPorId() {
        return "Ninja encontrado com sucesso!";
    }

    //mostrar todos os ninjas(READ)
    @GetMapping("/mostrarTodosNinjas")
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaService.mostrarTodosNinjas();
    }

    //alterar dados do ninja(UPDATE)
    @PostMapping("/alterarNinja")
    public NinjaModel alterarNinja() {
        return ninjaService.alterarNinja(new NinjaModel());
    }

    //deletar ninja por id(DELETE)
    @DeleteMapping("/deletarNinja")
    public String deletarNinja() {
        return "Ninja deletado com sucesso!";
    }





}
