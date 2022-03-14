package com.example.apijokenpo.controller;


import com.example.apijokenpo.dto.request.CreateInputDTO;
import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.InputResponseDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.service.InputService;
import com.example.apijokenpo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Classe do RestController do input
 *
 * @author pablo
 */

@RestController
@RequestMapping("/inputs")
public class InputController {

    @Autowired
    InputService inputService;


    /**
     * Método que cria o player
     *
     * @param createInputDTO
     * @return ResponseEntity<Void>
     */

    @PostMapping
    public ResponseEntity<Void> createPlayer(@RequestBody CreateInputDTO createInputDTO) {
        InputResponseDTO response = inputService.create(createInputDTO);
        return ResponseEntity.created(URI.create("http://localhost:8080/inputs/" + response.getId())).build();

    }

    /**
     * Metodo que retorna  uma lista de Players
     *
     * @return PlayerResponseDTO
     */

    @GetMapping
    public ResponseEntity<List<InputResponseDTO>> getAll() {
        List<InputResponseDTO> responseList = inputService.getAll();

        return ResponseEntity.ok(responseList);
    }


    /**
     * Metodo que Retorna um Player pelo id
     *
     * @param id
     * @return ResponseEntity<PlayerResponseDTO>
     */

    @GetMapping("/{id}")
    public ResponseEntity<InputResponseDTO> getOneById(@PathVariable Long id) {

        return ResponseEntity.ok().body(inputService.getOneById(id));
    }

    /**
     * Metodo que deleta um player
     * @param id
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> delete(@PathVariable Long id){

        inputService.delete(id);

        return ResponseEntity.noContent().build();

    }


}
