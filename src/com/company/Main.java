package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;

        // Main Menu Loop
        do {
            System.out.println("Greetings, legend! What will you be doing?\n");

            System.out.println("1) Create New Character");
            System.out.println("2) Play");
            System.out.println("3) Quit\n");

            choice = inp.nextInt();
            System.out.println();

            // Create New Character
            if (choice == 1)
                characterCreation();
            // Play Game
            else if (choice == 2)
                play();
        } while (choice != 3);

        System.out.println("Thank you for playing!");
    }

    // Character Creation Sequence
    static void characterCreation() {
        // Choose race
        System.out.println("Welcome to the world of Victorias! To start off your journey, please choose a race: \n");

        int playerRace;
        do {
            System.out.println("1) Hyur");
            System.out.println("2) Hrothgar");
            System.out.println("3) Istari\n");
            System.out.println("4) INFO ON THE RACES\n");

            System.out.print("Enter the number: ");
            playerRace = inp.nextInt();

            if (playerRace == 4) {
                System.out.println();
                System.out.println("╔════════════════════╗");
                System.out.println("║HYUR                ║");
                System.out.println("║+20 Max Health      ║");
                System.out.println("║                    ║");
                System.out.println("║HROTHGAR            ║");
                System.out.println("║+10 Physical Attack ║");
                System.out.println("║+10 Physical Defense║");
                System.out.println("║                    ║");
                System.out.println("║ISTARI              ║");
                System.out.println("║+10 Magical Attack  ║");
                System.out.println("║+10 Magical Defense ║");
                System.out.println("╚════════════════════╝");
                System.out.println();
            }
        } while (playerRace < 1 || playerRace > 3);

        // Choose name
        String playerName;
        File player;
        inp.nextLine();
        do {
            System.out.println();
            System.out.print("Enter your name: ");

            playerName = inp.nextLine();

            String playerFile = "Players\\" + playerName + ".txt";
            player = new File(playerFile);

            if (player.exists())
                System.out.println("Name has been taken. Please enter again.");
        } while (player.exists());

        // Write description
        System.out.println("\nGreetings, " + playerName + "! Now, give a short description about yourself: \n");

        String playerBio = inp.nextLine();

        System.out.println("\nYou're character has been born! You may now start your adventure through the world of Victorias with " + playerName + ".\n");

        // Initialize base stats
        int playerMaxHealth = 50;
        int playerMaxMana = 50;
        int playerPhysicalAttack = 10;
        int playerMagicalAttack = 10;
        int playerPhysicalDefense = 10;
        int playerMagicalDefense = 10;

        // Add racial bonuses to base stats
        switch (playerRace) {
            case 1: {
                playerMaxHealth += 20;
                break;
            }
            case 2: {
                playerPhysicalAttack += 10;
                playerPhysicalDefense += 10;
                break;
            }
            case 3: {
                playerMagicalAttack += 10;
                playerMagicalDefense += 10;
                break;
            }
        }

        // Create the new character file
        new NewPlayer(playerName, playerRace, playerBio,
                playerMaxHealth, playerMaxMana,
                playerPhysicalAttack, playerMagicalAttack,
                playerPhysicalDefense, playerMagicalDefense);
    }

    // Main Game Function
    static void play() {
        System.out.print("Enter your name: ");

        inp.nextLine();
        String playerName = inp.nextLine();

        String playerFile = "Players\\" + playerName + ".txt";
        File player = new File(playerFile);

        if (player.exists())
            play(playerName);
        else
            System.out.println("\nCharacter does not exist!\n");
    }

    static void play(String playerName) {
        Player player = new Player(playerName);

        // Allocate stat variables in a local runtime environment
        String playerBio = player.getPlayerBio();
        int playerMaxHealth = player.getPlayerMaxHealth();
        int playerHealth = player.getPlayerHealth();
        int playerMaxMana = player.getPlayerMaxMana();
        int playerMana = player.getPlayerMana();
        int playerPhysicalAttack = player.getPlayerPhysicalAttack();
        int playerMagicalAttack = player.getPlayerMagicalAttack();
        int playerPhysicalDefense = player.getPlayerPhysicalDefense();
        int playerMagicalDefense = player.getPlayerMagicalDefense();
        int playerLevel = player.getPlayerLevel();
        int playerMaxXP = player.getPlayerMaxXP();
        int playerXP = player.getPlayerXP();

        int choice;

        do {
            System.out.println("\nGreetings, " + player.getPlayerName() + "! What's your next course of action?\n");

            System.out.println("1) PROFILE");
            System.out.println("2) FIGHT");
            System.out.println("3) SAVE");
            System.out.println("4) Logout\n");

            System.out.print("Enter the number: ");
            choice = inp.nextInt();
            System.out.println();

            switch (choice) {
                // Open profile Screen
                case 1: {
                    System.out.println("PROFILE");
                    System.out.println("NAME: " + playerName);
                    System.out.println("RACE: " + player.getPlayerRace());
                    System.out.println("BIO: " + playerBio);
                    System.out.println("LEVEL: " + playerLevel);
                    System.out.println("XP: " + playerXP+ "/" + playerMaxXP);
                    System.out.println("HEALTH: " + playerHealth + "/" + playerMaxHealth);
                    System.out.println("MANA: " + playerMana + "/" + playerMaxMana);
                    System.out.println("PHYSICAL ATTACK: " + playerPhysicalAttack);
                    System.out.println("MAGICAL ATTACK: " + playerMagicalAttack);
                    System.out.println("PHYSICAL DEFENSE: " + playerPhysicalDefense);
                    System.out.println("MAGICAL DEFENSE: " + playerMagicalDefense);
                    System.out.println();
                    break;
                }
                case 2: {
                    // test code
                    playerHealth -= 5;
                    System.out.println("You received 5 damage!");
                    break;
                }
                // Save progress
                case 3: {
                    save(player, playerMaxHealth, playerHealth, playerMaxMana, playerMana,
                            playerPhysicalAttack, playerMagicalAttack, playerPhysicalDefense, playerMagicalDefense,
                            playerLevel, playerMaxXP, playerXP);
                    System.out.println("Progress has been saved successfully.");
                    break;
                }
                // Logging out saves your progress before returning to the main menu
                case 4: {
                    save(player, playerMaxHealth, playerHealth, playerMaxMana, playerMana,
                            playerPhysicalAttack, playerMagicalAttack, playerPhysicalDefense, playerMagicalDefense,
                            playerLevel, playerMaxXP, playerXP);
                    break;
                }
            }
        } while (choice != 4);
    }

    static void fight() {

    }

    // Save progress function
    static void save(Player player,
                     int playerMaxHealth, int playerHealth, int playerMaxMana, int playerMana,
                     int playerPhysicalAttack, int playerMagicalAttack, int playerPhysicalDefense, int playerMagicalDefense,
                     int playerLevel, int playerMaxXP, int playerXP) {
        player.setPlayerMaxHealth(playerMaxHealth);
        player.setPlayerHealth(playerHealth);
        player.setPlayerMaxMana(playerMaxMana);
        player.setPlayerMana(playerMana);
        player.setPlayerPhysicalAttack(playerPhysicalAttack);
        player.setPlayerMagicalAttack(playerMagicalAttack);
        player.setPlayerPhysicalDefense(playerPhysicalDefense);
        player.setPlayerMagicalDefense(playerMagicalDefense);
        player.setPlayerLevel(playerLevel);
        player.setPlayerMaxXP(playerMaxXP);
        player.setPlayerXP(playerXP);

        player.writeToPlayerFile(player.getPlayerName());
    }
}
