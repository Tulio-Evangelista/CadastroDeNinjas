package com.java10x.CadastroDeNinja.Missoes.MissoesController;


import com.java10x.CadastroDeNinja.Missoes.MissoesModel.MissoesModel;
import com.java10x.CadastroDeNinja.Missoes.MissoesService.MissoesService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("missoes/")
public class MissoesController {

    private MissoesService missoesService;
    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @PostMapping("/criarMissao")
    public MissoesModel criarMissao() {
        return missoesService.criarMissao(new MissoesModel());
    };

    @GetMapping("/MostrarMissao/{id}")
    public MissoesModel procurarMissaoPorId(@PathVariable Long id) {
        return missoesService.procurarMissaoPorId(id);
    };



    @GetMapping("/mostrarTodasMissoes")
    public List<MissoesModel> mostrarTodasMissoes() {
        return missoesService.listarTodasMissoes();
    };

    @PostMapping("/alterarMissao")
    public MissoesModel alterarMissao() {
        return missoesService.alterarMissao(new MissoesModel());
    };


    @DeleteMapping("/deletarMissao")
    public MissoesModel deletarMissao() {
        return missoesService.alterarMissao(new MissoesModel());
    };

}
