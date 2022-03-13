package com.example.apijokenpo.controller;


import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Classe do RestController do player
 * @author pablo
 */

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;


    /**
     * Método que cria o player
     * @param createPlayerDTO
     * @return ResponseEntity<Void>
     */

    @PostMapping
    public ResponseEntity<Void> createPlayer(@RequestBody CreatePlayerDTO createPlayerDTO) {
        PlayerResponseDTO response = playerService.create(createPlayerDTO);
        return ResponseEntity.created(URI.create("http://localhost:8080/player/" + response.getId())).build();

    }

    /**
     * Metodo que retorna  uma lista de Players
     * @return PlayerResponseDTO
     */

    @GetMapping
    public ResponseEntity<List<PlayerResponseDTO>> getAll(){
        List<PlayerResponseDTO> responseList = playerService.getAll();
        return ResponseEntity.ok(responseList);
    }


    /**
     * Metodo que Retorna um Player pelo id
     * @param id
     * @return ResponseEntity<PlayerResponseDTO>
     */

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponseDTO> getOneById(@PathVariable Long id){
        return  ResponseEntity.ok().body(playerService.getOneById(id));
    }




}
