package com.example.apijokenpo.service;

import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.PlayerEntity;
import com.example.apijokenpo.repository.PlayerRepository;
import com.example.apijokenpo.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponseDTO create(CreatePlayerDTO createPlayerDTO){
        PlayerEntity entity = ConverterUtil.toEntity(createPlayerDTO);

        PlayerEntity savedEntity =  playerRepository.save(entity);

        PlayerResponseDTO dto = ConverterUtil.toDTO(savedEntity);
    }

}
