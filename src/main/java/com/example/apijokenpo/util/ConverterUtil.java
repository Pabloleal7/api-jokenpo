package com.example.apijokenpo.util;

import com.example.apijokenpo.dto.request.CreateInputDTO;
import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.InputResponseDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.InputEntity;
import com.example.apijokenpo.entity.PlayerEntity;

/**
 * Classe com Metodos utilitarios que converte classes
 */

public class ConverterUtil {

    /* Player*/

    /**
     * Metodo que Converte um createPlayerDTO Para PlayerEntity
     *
     * @param createPlayerDTO
     * @return PlayerEntity
     */

    public static PlayerEntity playerToEntity(CreatePlayerDTO createPlayerDTO) {
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(createPlayerDTO.getName());
        return playerEntity;
    }

    /**
     * Metodo que Converte PlayerEntity para PlayerResponseDTO
     *
     * @param entity
     * @return PlayerResponseDTO
     */

    public static PlayerResponseDTO playerToDTO(PlayerEntity entity) {
        PlayerResponseDTO dto = new PlayerResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }


    /*   Input   */


    /**
     * Metodo que Converte um createPlayerDTO Para PlayerEntity
     *
     * @param createInputDTO
     * @return InputEntity
     */

    public static InputEntity inputToEntity(CreateInputDTO createInputDTO) {
        InputEntity inputEntity = new InputEntity();
        inputEntity.setMatchEntity(createInputDTO.getMatchEntity());
        inputEntity.setPlayerEntity(createInputDTO.getPlayerEntity());
        inputEntity.setInputsEnum(createInputDTO.getInputsEnum());

        return inputEntity;
    }

    /**
     * Metodo que Converte PlayerEntity para PlayerResponseDTO
     *
     * @param entity
     * @return InputResponseDTO
     */

    public static InputResponseDTO inputToDTO(InputEntity entity) {
        InputResponseDTO dto = new InputResponseDTO();
        dto.setId(entity.getId());
        dto.setMatchEntity(entity.getMatchEntity());
        dto.setPlayerEntity(entity.getPlayerEntity());
        dto.setInputsEnum(entity.getInputsEnum());

        return dto;
    }
}
