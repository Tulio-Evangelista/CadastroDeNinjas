package com.java10x.CadastroDeNinja.missoes.mapper;


import com.java10x.CadastroDeNinja.missoes.dto.MissoesDTO;
import com.java10x.CadastroDeNinja.missoes.MissoesModel;
import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO MissoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(MissoesDTO.getId());
        missoesModel.setNome(MissoesDTO.getNome());
        missoesModel.setGrauDificuldade(MissoesDTO.getGrauDificuldade());
        missoesModel.setNinjas(MissoesDTO.getNinjas());

        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        MissoesDTO missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setGrauDificuldade(missoesModel.getGrauDificuldade());
        missoesDTO.setNinjas(missoesModel.getNinjas());

        return missoesDTO;
    }

}
