package com.example.apijokenpo.util;

import com.example.apijokenpo.entity.InputsEnum;

public class Play {


   /* public static void main(String[] args) {
        PlayerCombate player1 = new PlayerCombate();
        PlayerCombate player2 = new PlayerCombate();
        PlayerCombate player3 = new PlayerCombate();

        player1.setInput(InputsEnum.SPOCK);
        player2.setInput(InputsEnum.PAPEL);
        player3.setInput(InputsEnum.PAPEL);


        player1 = combat(player1, player2);
        player1 = combat(player1, player3);
        player2 = combat(player2, player1);
        player2 = combat(player2, player3);
        player3 = combat(player3, player1);
        player3 = combat(player3, player2);

        System.out.println("Player1:" + player1.getPoints());
        System.out.println("Player2:" + player2.getPoints());
        System.out.println("Player3:" + player3.getPoints());
    }
*/

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
