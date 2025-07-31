package com.java10x.CadastroDeNinja.missoes.missoesService;


import com.java10x.CadastroDeNinja.missoes.dto.MissoesDTO;
import com.java10x.CadastroDeNinja.missoes.mapper.MissoesMapper;
import com.java10x.CadastroDeNinja.missoes.MissoesModel;
import com.java10x.CadastroDeNinja.missoes.missoesRepository.MissoesRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private final MissoesMapper missoesMapper;
    private MissoesRepository missoesRepository;
    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    //listar todas as missões
    public List<MissoesDTO> listarTodasMissoes() {
        List<MissoesModel> listaDeMissoes = missoesRepository.findAll();
        return listaDeMissoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    //criar missão
    public MissoesDTO criarMissao(MissoesDTO missoesDTO) {
       MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    //alterar missão
    public MissoesDTO alterarMissao( Long id  ,MissoesDTO missaoAlterada) {
        Optional<MissoesModel> missaoExistente = missoesRepository.findById(id);
        if (missoesRepository.existsById(id)) {
           MissoesModel missoesAlterada = missoesMapper.map(missaoAlterada);
            missoesAlterada.setId(id);
            MissoesModel missoesSalva = missoesRepository.save(missoesAlterada);
            return missoesMapper.map(missoesSalva);
        }
        return null;
    }

    //procurar missão por id
    public MissoesDTO procurarMissaoPorId(Long id) {
        Optional<MissoesModel> missoesPorId = missoesRepository.findById(id);
        return missoesPorId
                .map(missoesMapper::map)
                .orElse(null);
    }

    //deletar missão por id
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
