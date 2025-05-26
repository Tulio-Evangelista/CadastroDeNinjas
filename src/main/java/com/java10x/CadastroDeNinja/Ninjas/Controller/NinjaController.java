package com.java10x.CadastroDeNinja.Ninjas.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/primeiraRota")
    public String primeiraRota(){
        return "Primeira Rota";
    }


}
