package com.example.apijokenpo.dto.response;


import com.example.apijokenpo.util.PlayerCombate;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultResponseDTO {

    private List<PlayerCombate> playerCombateList;
    private String mensagem;







}
