package com.java10x.CadastroDeNinja.ninjas.ninjaService;

import com.java10x.CadastroDeNinja.ninjas.dto.NinjaDTO;
import com.java10x.CadastroDeNinja.ninjas.mapper.NinjaMapper;
import com.java10x.CadastroDeNinja.ninjas.ninjaModel.NinjaModel;
import com.java10x.CadastroDeNinja.ninjas.ninjaRepository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {


    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    @Autowired
    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaDTO> mostrarTodosNinjas() {
        List<NinjaModel> listaDeNinjas = ninjaRepository.findAll();
        return listaDeNinjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());

    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //Alterar dados do ninja
    public NinjaDTO alterarNinja(Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaAtualizado);
        } else {
            return null;
        }
    }

    //Procurar ninja por id
    public NinjaDTO procurarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId
                .map(ninjaMapper::map)
                .orElse(null);
    }


    //deletar ninja por id
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }






}
