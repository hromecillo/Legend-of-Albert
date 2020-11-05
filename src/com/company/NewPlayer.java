package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewPlayer extends PlayerInfo implements Save {

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

        writeToPlayerFile(getPlayerName());
    }

    // Writes the starting data into the player's new personal data file
    @Override
    public void writeToPlayerFile(String playerName) {
        String playerFile = "Players\\" + playerName + ".txt";
        File character = new File(playerFile);

        try {
            if (character.createNewFile()) {
                FileWriter characterWriter = new FileWriter(playerFile);

                characterWriter.append(String.valueOf(getPlayerMaxHealth())).append("\n");
                characterWriter.append(String.valueOf(getPlayerHealth())).append("\n");
                characterWriter.append(String.valueOf(getPlayerMaxMana())).append("\n");
                characterWriter.append(String.valueOf(getPlayerMana())).append("\n");
                characterWriter.append(String.valueOf(getPlayerPhysicalAttack())).append("\n");
                characterWriter.append(String.valueOf(getPlayerMagicalAttack())).append("\n");
                characterWriter.append(String.valueOf(getPlayerPhysicalDefense())).append("\n");
                characterWriter.append(String.valueOf(getPlayerMagicalDefense())).append("\n");
                characterWriter.append(String.valueOf(getPlayerLevel())).append("\n");
                characterWriter.append(String.valueOf(getPlayerMaxXP())).append("\n");
                characterWriter.append(String.valueOf(getPlayerXP())).append("\n");
                characterWriter.append(getPlayerName()).append("\n");
                characterWriter.append(getPlayerRace()).append("\n");
                characterWriter.append(getPlayerBio()).append("\n");

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
