package com.java10x.CadastroDeNinja.Ninjas.Controller;

import com.java10x.CadastroDeNinja.Ninjas.DTO.NinjaDTO;
import com.java10x.CadastroDeNinja.Ninjas.NinjaModel.NinjaModel;
import com.java10x.CadastroDeNinja.Ninjas.NinjaService.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja =  ninjaService.criarNinja(ninja);
        return  ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //procurar ninja por id(CREATE)
    @GetMapping("/MostrarNinja/{id}")
    public ResponseEntity<String> procurarNinjaPorId(@PathVariable Long id) {
         if (ninjaService.procurarNinjaPorId(id) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Ninja encontrado: " + ninjaService.procurarNinjaPorId(id).toString() + " (ID): " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado.");
        }
    }

    //mostrar todos os ninjas(READ)
    @GetMapping("/mostrarTodosNinjas")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosNinjas() {
        List<NinjaDTO> listaNinjas = ninjaService.mostrarTodosNinjas();
        return ResponseEntity.ok(listaNinjas);
    }

    //alterar dados do ninja(UPDATE)
    @PutMapping("/alterarNinja/{id}")
    public ResponseEntity<String> alterarNinja(@PathVariable long id,@RequestBody NinjaDTO ninjaDTO) {
        if (ninjaService.procurarNinjaPorId(id) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Ninja com ID " + id + " alterado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado.");
        }

    }

    //deletar ninja por id(DELETE)
    @DeleteMapping("/deletarNinja/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.procurarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return  ResponseEntity.status(HttpStatus.CREATED).body( id + " deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado.");
        }

    }





}
