package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewPlayer extends PlayerInfo {

    NewPlayer(String playerName, int playerRace, String playerBio,
              int playerMaxHealth, int playerMaxMana,
              int playerPhysicalAttack, int playerMagicalAttack,
              int playerPhysicalDefense, int playerMagicalDefense) {

        // Set starting data
        setPlayerMaxHealth(playerMaxHealth);
        setPlayerHealth(playerMaxHealth);
        setPlayerMaxMana(playerMaxMana);
        setPlayerMana(playerMaxMana);
        setPlayerPhysicalAttack(playerPhysicalAttack);
        setPlayerMagicalAttack(playerMagicalAttack);
        setPlayerPhysicalDefense(playerPhysicalDefense);
        setPlayerMagicalDefense(playerMagicalDefense);
        setPlayerLevel(1);
        setPlayerMaxXP(100);
        setPlayerXP(0);
        setPlayerName(playerName);

        switch (playerRace) {
            case 1: {
                setPlayerRace("Hyur");
                break;
            }
            case 2: {
                setPlayerRace("Hrothgar");
                break;
            }
            case 3: {
                setPlayerRace("Istari");
                break;
            }
        }

        setPlayerBio(playerBio);

        createCharacter();
    }

    // Writes the starting data into the player's personal data file
    void createCharacter() {
        String playerFile = "Players\\" + getPlayerName() + ".txt";

        File character = new File(playerFile);
        try {
            if (character.createNewFile()) {
                FileWriter characterWriter = new FileWriter(playerFile);

                characterWriter.append(getPlayerMaxHealth() + "\n");
                characterWriter.append(getPlayerHealth() + "\n");
                characterWriter.append(getPlayerMaxMana() + "\n");
                characterWriter.append(getPlayerMana() + "\n");
                characterWriter.append(getPlayerPhysicalAttack() + "\n");
                characterWriter.append(getPlayerMagicalAttack() + "\n");
                characterWriter.append(getPlayerPhysicalDefense() + "\n");
                characterWriter.append(getPlayerMagicalDefense() + "\n");
                characterWriter.append(getPlayerLevel() + "\n");
                characterWriter.append(getPlayerMaxXP() + "\n");
                characterWriter.append(getPlayerXP() + "\n");
                characterWriter.append(getPlayerName() + "\n");
                characterWriter.append(getPlayerRace() + "\n");
                characterWriter.append(getPlayerBio() + "\n");

                characterWriter.close();
            } else {
                System.out.println("ERROR: Name already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
