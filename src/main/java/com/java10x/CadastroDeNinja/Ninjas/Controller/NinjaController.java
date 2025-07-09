package com.java10x.CadastroDeNinja.Ninjas.Controller;

 refactor
import com.java10x.CadastroDeNinja.Ninjas.DTO.NinjaDTO;
import com.java10x.CadastroDeNinja.Ninjas.NinjaModel.NinjaModel;
import com.java10x.CadastroDeNinja.Ninjas.NinjaService.NinjaService;
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


=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

  main
    @GetMapping("/primeiraRota")
    public String primeiraRota(){
        return "Primeira Rota";
    }

refactor
    //adicionar ninja(CREATE)
    @PostMapping("/criarNinja")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        return  ninjaService.criarNinja(ninjaDTO);
    }

    //procurar ninja por id(CREATE)
    @GetMapping("/MostrarNinja/{id}")
    public NinjaDTO procurarNinjaPorId(@PathVariable Long id) {
        return ninjaService.procurarNinjaPorId(id);
    }

    //mostrar todos os ninjas(READ)
    @GetMapping("/mostrarTodosNinjas")
    public List<NinjaDTO> mostrarTodosNinjas() {
        return ninjaService.mostrarTodosNinjas();
    }

    //alterar dados do ninja(UPDATE)
    @PutMapping("/alterarNinja/{id}")
    public NinjaDTO alterarNinja(@PathVariable long id,@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.alterarNinja(id, ninjaDTO);
    }

    //deletar ninja por id(DELETE)
    @DeleteMapping("/deletarNinja/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }




 main

}
