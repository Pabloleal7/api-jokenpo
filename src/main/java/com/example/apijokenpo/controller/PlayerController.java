package com.example.apijokenpo.controller;


import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import com.example.apijokenpo.dto.response.PlayerResponseDTO;
import com.example.apijokenpo.service.PlayerService;
import com.example.apijokenpo.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;


    @PostMapping
    public ResponseEntity<Void> createPlayer(@RequestBody CreatePlayerDTO createPlayerDTO) {
        PlayerResponseDTO response = playerService.create(createPlayerDTO);
        return ResponseEntity.created(URI.create("http://localhost:8080/player/" + response.getId())).build();

    }




}
