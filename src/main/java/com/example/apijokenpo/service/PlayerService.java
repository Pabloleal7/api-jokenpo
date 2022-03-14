package com.example.apijokenpo.service;

import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.PlayerEntity;
import com.example.apijokenpo.repository.PlayerRepository;
import com.example.apijokenpo.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public PlayerResponseDTO create(CreatePlayerDTO createPlayerDTO) {
        PlayerEntity entity = ConverterUtil.playerToEntity(createPlayerDTO);

        PlayerEntity savedEntity = playerRepository.save(entity);

        return ConverterUtil.playerToDTO(savedEntity);
    }

    public List<PlayerResponseDTO> getAll() {

        return getAllStream().collect(Collectors.toList());

    }

    public PlayerResponseDTO getOneById(Long id){
        return ConverterUtil.playerToDTO(Objects.requireNonNull(playerRepository.findById(id).orElse(null)));
    }

    public void delete(Long id){
        playerRepository.deleteById(id);
    }

    public Stream<PlayerResponseDTO> getAllStream() {
        return playerRepository.findAll().stream()
                .map(ConverterUtil::playerToDTO);
    }

}
