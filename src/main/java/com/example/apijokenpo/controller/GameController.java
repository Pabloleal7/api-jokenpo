package com.example.apijokenpo.controller;
import com.example.apijokenpo.dto.response.ResultResponseDTO;
import com.example.apijokenpo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/play")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<ResultResponseDTO> result(@PathVariable Long id){

      return ResponseEntity.ok(gameService.result(id)) ;



    }


}
