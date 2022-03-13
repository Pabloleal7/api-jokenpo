package com.example.apijokenpo.util;

import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.PlayerEntity;

/**
 * Classe com Metodos utilitarios que converte classes
 */

public class ConverterUtil {

    /**
     * Metodo que Converte um createPlayerDTO Para PlayerEntity
     * @param createPlayerDTO
     * @return PlayerEntity
     */

    public static PlayerEntity toEntity(CreatePlayerDTO createPlayerDTO){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(createPlayerDTO.getName());
        return playerEntity;
    }

    /**
     * Metodo que Converte PlayerEntity para PlayerResponseDTO
     * @param entity
     * @return PlayerResponseDTO
     *
     */

    public static PlayerResponseDTO toDTO(PlayerEntity entity) {
        PlayerResponseDTO dto = new PlayerResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return  dto;
    }
}
