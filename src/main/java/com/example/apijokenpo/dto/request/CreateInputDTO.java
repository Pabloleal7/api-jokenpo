package com.example.apijokenpo.dto.request;


import com.example.apijokenpo.entity.InputsEnum;
import com.example.apijokenpo.entity.MatchEntity;
import com.example.apijokenpo.entity.PlayerEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInputDTO {


    private MatchEntity matchEntity;

    private PlayerEntity playerEntity;

    private InputsEnum inputsEnum;


}
