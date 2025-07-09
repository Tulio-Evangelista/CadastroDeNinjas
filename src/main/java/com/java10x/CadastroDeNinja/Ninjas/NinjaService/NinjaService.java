package com.java10x.CadastroDeNinja.Ninjas.NinjaService;

import com.java10x.CadastroDeNinja.Ninjas.DTO.NinjaDTO;
import com.java10x.CadastroDeNinja.Ninjas.Mapper.NinjaMapper;
import com.java10x.CadastroDeNinja.Ninjas.NinjaModel.NinjaModel;
import com.java10x.CadastroDeNinja.Ninjas.NinjaRepository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {


    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    //Listar todos os ninjas
    public List<NinjaModel> mostrarTodosNinjas() {
        return ninjaRepository.findAll();

    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //Alterar dados do ninja
    public NinjaModel alterarNinja(Long id, NinjaModel ninjaAlterado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAlterado.setId(id);
            return ninjaRepository.save(ninjaAlterado);
        }
        return null;
    }

    //Procurar ninja por id
    public NinjaModel procurarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
    }


    //deletar ninja por id
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }






}
