package com.java10x.CadastroDeNinja.Ninjas.NinjaService;

import com.java10x.CadastroDeNinja.Ninjas.NinjaModel.NinjaModel;
import com.java10x.CadastroDeNinja.Ninjas.NinjaRepository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaRepository.findAll();

    }

    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public NinjaModel alterarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

public NinjaModel procurarNinjaPorId(Long id) {
    Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }









}
