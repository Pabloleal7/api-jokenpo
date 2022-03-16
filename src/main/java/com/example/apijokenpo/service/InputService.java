package com.example.apijokenpo.service;

import com.example.apijokenpo.dto.request.CreateInputDTO;
import com.example.apijokenpo.dto.response.InputResponseDTO;
import com.example.apijokenpo.entity.InputEntity;

import com.example.apijokenpo.repository.InputRepository;
import com.example.apijokenpo.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;

    /**
     * Metodo que salva a jogada no banco de dados
     * @param createInputDTO
     * @return
     */

    //Nada performatico mas é funcional
    public InputResponseDTO create(CreateInputDTO createInputDTO) {

        Integer inputsLength = 0;

        for (InputResponseDTO inputResponseDTO : getAll()) {
            if (inputResponseDTO.getMatchEntity().getId() == createInputDTO.getMatchEntity().getId()) {
                inputsLength++;
            }

        }

        if (inputsLength < 3) {
            InputEntity entity = ConverterUtil.inputToEntity(createInputDTO);

            InputEntity savedEntity = inputRepository.save(entity);

            return ConverterUtil.inputToDTO(savedEntity);

        }

        return null;


    }

    /**
     * Metodo que retorna uma lista das jogadas que estão salvas no banco de dados
     * @return
     */

    public List<InputResponseDTO> getAll() {

        return getAllStream().collect(Collectors.toList());

    }

    public InputResponseDTO getOneById(Long id) {
        return ConverterUtil.inputToDTO(Objects.requireNonNull(inputRepository.findById(id).orElse(null)));
    }

    public void delete(Long id) {
        inputRepository.deleteById(id);
    }

    public Stream<InputResponseDTO> getAllStream() {
        return inputRepository.findAll().stream()
                .map(ConverterUtil::inputToDTO);
    }
}
