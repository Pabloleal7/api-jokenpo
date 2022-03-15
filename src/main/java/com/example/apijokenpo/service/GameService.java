package com.example.apijokenpo.service;

import com.example.apijokenpo.dto.response.InputResponseDTO;
import com.example.apijokenpo.dto.response.ResultResponseDTO;
import com.example.apijokenpo.util.Play;
import com.example.apijokenpo.util.PlayerCombate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GameService {

    @Autowired
    InputService inputService;


    public ResultResponseDTO result(Long id) {


        ResultResponseDTO dto = new ResultResponseDTO();


        List<PlayerCombate> playerCombateList = new ArrayList<>();


        for (InputResponseDTO input : inputService.getAll()) {

            PlayerCombate playerCombate = new PlayerCombate();

            if (input.getMatchEntity().getId() == id) {
                playerCombate.setInput(input.getInputsEnum());
                playerCombate.setName(input.getPlayerEntity().getName());
                playerCombate.setPoints(0);

                playerCombateList.add(playerCombate);
            }

        }





        PlayerCombate p1 = playerCombateList.get(0);
        PlayerCombate p2 = playerCombateList.get(1);
        PlayerCombate p3 = playerCombateList.get(2);


        playerCombateList.set(0, Play.combat(p1, p2));
        playerCombateList.set(0, Play.combat(p1, p3));

        playerCombateList.set(1, Play.combat(p2, p1));
        playerCombateList.set(1, Play.combat(p2, p3));

        playerCombateList.set(2, Play.combat(p3, p1));
        playerCombateList.set(2, Play.combat(p3, p2));


        for (PlayerCombate playerCombate : playerCombateList
        ) {

            if (playerCombate.getPoints() >= 2) {
                dto.setMensagem(playerCombate.getName() + " Ganhou");
                break;
            } else {
                dto.setMensagem("Empate");
            }


        }


        dto.setPlayerCombateList(playerCombateList);


        return dto;

    }


}
