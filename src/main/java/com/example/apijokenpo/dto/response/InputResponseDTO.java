package com.example.apijokenpo.dto.response;


import com.example.apijokenpo.entity.InputsEnum;
import com.example.apijokenpo.entity.MatchEntity;
import com.example.apijokenpo.entity.PlayerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputResponseDTO {

    private Long id;

    private MatchEntity matchEntity;

    private PlayerEntity playerEntity;

    private InputsEnum inputsEnum;


}
