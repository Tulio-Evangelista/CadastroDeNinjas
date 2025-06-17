package com.java10x.CadastroDeNinja.Missoes.MissoesService;


import com.java10x.CadastroDeNinja.Missoes.MissoesModel.MissoesModel;
import com.java10x.CadastroDeNinja.Missoes.MissoesRepository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //listar todas as missões
    public List<MissoesModel> listarTodasMissoes() {
        return missoesRepository.findAll();
    }

    //criar missão
    public MissoesModel criarMissao(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

    //alterar missão
    public MissoesModel alterarMissao(MissoesModel missoes) {
        return missoesRepository.save(missoes);
    }

}
