package com.example.apijokenpo.controller;


import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.entity.MatchEntity;
import com.example.apijokenpo.service.MatchService;
import com.example.apijokenpo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Classe do RestController do player
 *
 * @author pablo
 */

@RestController
@RequestMapping("/matchs")
public class MatchController {

    @Autowired
    MatchService matchService;


    /**
     * Método que cria o player
     *
     * @return ResponseEntity<Void>
     */

    @PostMapping
    public ResponseEntity<MatchEntity> createMatch() {
        MatchEntity matchEntity = new MatchEntity();

        MatchEntity response = matchService.create(matchEntity);



        return ResponseEntity.created(URI.create("http://localhost:8080/matchs/" + response.getId())).body(response);

    }

    /**
     * Metodo que retorna  uma lista de Players
     *
     * @return PlayerResponseDTO
     */

    @GetMapping
    public ResponseEntity<List<MatchEntity>> getAll() {
        List<MatchEntity> responseList = matchService.getAll();

        return ResponseEntity.ok(responseList);
    }


    /**
     * Metodo que Retorna um Player pelo id
     *
     * @param id
     * @return ResponseEntity<PlayerResponseDTO>
     */

    @GetMapping("/{id}")
    public ResponseEntity<MatchEntity> getOneById(@PathVariable Long id) {

        return ResponseEntity.ok().body(matchService.getOneById(id));
    }

    /**
     * Metodo que deleta um player
     *
     * @param id
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<MatchEntity> delete(@PathVariable Long id) {

        matchService.delete(id);

        return ResponseEntity.noContent().build();

    }


}
