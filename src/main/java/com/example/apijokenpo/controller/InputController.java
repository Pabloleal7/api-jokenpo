package com.example.apijokenpo.controller;


import com.example.apijokenpo.dto.request.CreateInputDTO;
import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.InputResponseDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.service.InputService;
import com.example.apijokenpo.service.PlayerService;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.apache.tomcat.util.json.JSONParser;
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
     * Método que cria as jogadas
     *
     * @param createInputDTO
     * @return
     */

    @PostMapping
    public ResponseEntity<String> createInput(@RequestBody CreateInputDTO createInputDTO) {
        InputResponseDTO response = inputService.create(createInputDTO);

        String msg = "Limite De jogadas nesta partida Excedido";

        if (response != null){
            return ResponseEntity.created(URI.create("http://localhost:8080/inputs/" + response.getId())).build();
        }
        return ResponseEntity.badRequest().body(msg);


    }

    /**
     * Metodo que retorna uma lista de jogadas
     *
     * @return PlayerResponseDTO
     */

    @GetMapping
    public ResponseEntity<List<InputResponseDTO>> getAll() {
        List<InputResponseDTO> responseList = inputService.getAll();

        return ResponseEntity.ok(responseList);
    }


    /**
     * Metodo que Retorna uma jogada pelo id
     *
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<InputResponseDTO> getOneById(@PathVariable Long id) {

        return ResponseEntity.ok().body(inputService.getOneById(id));
    }

    /**
     * Metodo que deleta uma jogada
     * @param id
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> delete(@PathVariable Long id){

        inputService.delete(id);

        return ResponseEntity.noContent().build();

    }


}
