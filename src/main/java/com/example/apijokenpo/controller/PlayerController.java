package com.example.apijokenpo.controller;


import com.example.apijokenpo.dto.request.CreatePlayerDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {


    @PostMapping
    public void createPlayer(@RequestBody CreatePlayerDTO createPlayerDTO){


    }


}
