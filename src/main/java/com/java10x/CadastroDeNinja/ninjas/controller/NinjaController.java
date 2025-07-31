package com.java10x.CadastroDeNinja.ninjas.controller;


import com.java10x.CadastroDeNinja.ninjas.dto.NinjaDTO;
import com.java10x.CadastroDeNinja.ninjas.ninjaService.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    public String primeiraRota() {
        return "Primeira Rota";
    }

    //adicionar ninja(CREATE)
    @PostMapping("/criarNinja")
    @Operation(summary = "Cria um novo ninja", description = "Endpoint para criar um novo ninja com os dados fornecidos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })

    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    //procurar ninja por id(CREATE)
    @GetMapping("/MostrarNinja/{id}")
    @Operation(summary = "Busca um ninja pelo ID", description = "Endpoint para buscar um ninja específico pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })

    public ResponseEntity<String> procurarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.procurarNinjaPorId(id) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Ninja encontrado: " + ninjaService.procurarNinjaPorId(id).toString() + " (ID): " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado.");
        }
    }

    //mostrar todos os ninjas(READ)
    @GetMapping("/mostrarTodosNinjas")
    @Operation(summary = "Lista todos os ninjas", description = "Endpoint para listar todos os ninjas cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ninjas retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum ninja encontrado")
    })

    public ResponseEntity<List<NinjaDTO>> mostrarTodosNinjas() {
        List<NinjaDTO> listaNinjas = ninjaService.mostrarTodosNinjas();
        return ResponseEntity.ok(listaNinjas);
    }

    //alterar dados do ninja(UPDATE)
    @PutMapping("/alterarNinja/{id}")
    @Operation(summary = "Altera os dados de um ninja", description = "Endpoint para alterar os dados de um ninja existente pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })

    public ResponseEntity<String> alterarNinja(@PathVariable long id, @RequestBody NinjaDTO ninjaDTO) {
        if (ninjaService.procurarNinjaPorId(id) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Ninja com ID " + id + " alterado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado.");
        }

    }

    //deletar ninja por id(DELETE)
    @DeleteMapping("/deletarNinja/{id}")
    @Operation(summary = "Deleta um ninja pelo ID", description = "Endpoint para deletar um ninja específico pelo seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })

    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if (ninjaService.procurarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado.");
        }

    }


    }

