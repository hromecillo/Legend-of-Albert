package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Player extends PlayerInfo {

    Player(String playerName) {
        String playerFile = "Players\\" + playerName + ".txt";

        File character = new File(playerFile);
        try {
            Scanner characterReader = new Scanner(character);

            setPlayerMaxHealth(Integer.parseInt(characterReader.nextLine()));
            setPlayerHealth(Integer.parseInt(characterReader.nextLine()));
            setPlayerMaxMana(Integer.parseInt(characterReader.nextLine()));
            setPlayerMana(Integer.parseInt(characterReader.nextLine()));
            setPlayerPhysicalAttack(Integer.parseInt(characterReader.nextLine()));
            setPlayerMagicalAttack(Integer.parseInt(characterReader.nextLine()));
            setPlayerPhysicalDefense(Integer.parseInt(characterReader.nextLine()));
            setPlayerMagicalDefense(Integer.parseInt(characterReader.nextLine()));
            setPlayerLevel(Integer.parseInt(characterReader.nextLine()));
            setPlayerMaxXP(Integer.parseInt(characterReader.nextLine()));
            setPlayerXP(Integer.parseInt(characterReader.nextLine()));
            setPlayerName(characterReader.nextLine());
            setPlayerRace(characterReader.nextLine());
            setPlayerBio(characterReader.nextLine());

            characterReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
