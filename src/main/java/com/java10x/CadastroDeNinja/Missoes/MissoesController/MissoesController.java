package com.java10x.CadastroDeNinja.Missoes.MissoesController;


import com.java10x.CadastroDeNinja.Missoes.DTO.MissoesDTO;
import com.java10x.CadastroDeNinja.Missoes.MissoesModel.MissoesModel;
import com.java10x.CadastroDeNinja.Missoes.MissoesService.MissoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO novaMissao = missoesService.criarMissao(missoesDTO);

        return ResponseEntity.status(201)
                .body("Missão criada com sucesso: " + novaMissao.toString() + " (ID): " + novaMissao.getId());
    };

    @GetMapping("/MostrarMissao/{id}")
    public ResponseEntity<String> procurarMissaoPorId(@PathVariable Long id) {
        if (missoesService.procurarMissaoPorId(id) != null) {
            return ResponseEntity.status(200).body("Missão encontrada: " + missoesService.procurarMissaoPorId(id).toString() + " (ID): " + id);
        } else {
            return ResponseEntity.status(404).body("Missão com ID " + id + " não encontrada.");
        }

    };



    @GetMapping("/mostrarTodasMissoes")
    public  ResponseEntity<List<MissoesDTO>>  mostrarTodasMissoes() {
       List<MissoesDTO> listaMissoes = missoesService.listarTodasMissoes();
        return ResponseEntity.ok(listaMissoes);
    };

    @PostMapping("/alterarMissao/{id}")
    public ResponseEntity<String> alterarMissao(@PathVariable long id, @RequestBody MissoesDTO missaoAlterada) {
        if (missoesService.procurarMissaoPorId(id) != null) {
            return ResponseEntity.status(200).body("Missão alterada com sucesso: " + missoesService.alterarMissao(id, missaoAlterada).toString() + " (ID): " + id);
        } else {
            return ResponseEntity.status(404).body("Missão com ID " + id + " não encontrada.");
        }

    };

    @DeleteMapping("/deletarMissao/{id}")
    public ResponseEntity<String> deletarMissaoPorId(@PathVariable Long id) {
        if (missoesService.procurarMissaoPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.status(200).body("Missão com ID " + id + " deletada com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Missão com ID " + id + " não encontrada.");
        }

    };

}
