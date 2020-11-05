package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player extends PlayerInfo implements Save {

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

    @Override
    public void writeToPlayerFile(String playerName) {
        String playerFile = "Players\\" + playerName + ".txt";
        File player = new File(playerFile);

        try {
            if (player.exists()) {
                FileWriter saveWriter = new FileWriter(playerFile, false);

                saveWriter.append(String.valueOf(getPlayerMaxHealth())).append("\n");
                saveWriter.append(String.valueOf(getPlayerHealth())).append("\n");
                saveWriter.append(String.valueOf(getPlayerMaxMana())).append("\n");
                saveWriter.append(String.valueOf(getPlayerMana())).append("\n");
                saveWriter.append(String.valueOf(getPlayerPhysicalAttack())).append("\n");
                saveWriter.append(String.valueOf(getPlayerMagicalAttack())).append("\n");
                saveWriter.append(String.valueOf(getPlayerPhysicalDefense())).append("\n");
                saveWriter.append(String.valueOf(getPlayerMagicalDefense())).append("\n");
                saveWriter.append(String.valueOf(getPlayerLevel())).append("\n");
                saveWriter.append(String.valueOf(getPlayerMaxXP())).append("\n");
                saveWriter.append(String.valueOf(getPlayerXP())).append("\n");
                saveWriter.append(getPlayerName()).append("\n");
                saveWriter.append(getPlayerRace()).append("\n");
                saveWriter.append(getPlayerBio()).append("\n");

                saveWriter.close();
            } else {
                System.out.println("ERROR: Name already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
