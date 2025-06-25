package com.java10x.CadastroDeNinja.Missoes.MissoesService;


import com.java10x.CadastroDeNinja.Missoes.MissoesModel.MissoesModel;
import com.java10x.CadastroDeNinja.Missoes.MissoesRepository.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public MissoesModel alterarMissao( Long id  ,MissoesModel missaoAlterada) {
        if (missoesRepository.existsById(id)) {
            missaoAlterada.setId(id);
            return missoesRepository.save(missaoAlterada);
        }
        return null;
    }

    //procurar missão por id
    public MissoesModel procurarMissaoPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId.orElse(null);
    }

    //deletar missão por id
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
