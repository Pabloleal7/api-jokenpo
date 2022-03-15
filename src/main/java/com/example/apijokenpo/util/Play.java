package com.example.apijokenpo.util;

import com.example.apijokenpo.entity.InputsEnum;

public class Play {



    public static PlayerCombate combat(PlayerCombate play1, PlayerCombate play2) {

        if (play1.getInput() == InputsEnum.SPOCK && (play2.getInput() == InputsEnum.TESOURA || play2.getInput() == InputsEnum.PEDRA)) {
            play1.setPoints(play1.getPoints() + 1);
        }

        if (play1.getInput() == InputsEnum.TESOURA && (play2.getInput() == InputsEnum.PAPEL || play2.getInput() == InputsEnum.LAGARTO)) {
            play1.setPoints(play1.getPoints() + 1);
        }

        if (play1.getInput() == InputsEnum.PAPEL && (play2.getInput() == InputsEnum.PEDRA || play2.getInput() == InputsEnum.SPOCK)) {
            play1.setPoints(play1.getPoints() + 1);
        }

        if (play1.getInput() == InputsEnum.PEDRA && (play2.getInput() == InputsEnum.LAGARTO || play2.getInput() == InputsEnum.TESOURA)) {
            play1.setPoints(play1.getPoints() + 1);
        }

        if (play1.getInput() == InputsEnum.LAGARTO && (play2.getInput() == InputsEnum.SPOCK || play2.getInput() == InputsEnum.PAPEL)) {
            play1.setPoints(play1.getPoints() + 1);
        }

        return play1;

    }


}
