package com.example.apijokenpo.util;

import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.PlayerEntity;

public class ConverterUtil {

    public static PlayerEntity toEntity(CreatePlayerDTO createPlayerDTO){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(createPlayerDTO.getName());
        return playerEntity;
    }

    public static PlayerResponseDTO toDTO(PlayerEntity entity) {
        PlayerResponseDTO dto = new PlayerResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return  dto;
    }
}
