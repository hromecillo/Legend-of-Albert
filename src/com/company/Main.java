package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    static Scanner inp = new Scanner(System.in);
    public static void main(String[] args) {

        int choice;

        // Main Game Loop
        do {

            System.out.println("Greetings, legend! What would you like to do?\n");

            System.out.println("1) Create New Character");
            System.out.println("2) Play");
            System.out.println("3) Quit\n");

            choice = inp.nextInt();
            System.out.println();

            // Create New Character
            if (choice == 1) {
                characterCreation();
            }
            // Play Game
            else if (choice == 2) {

                System.out.print("Enter your name: ");

                inp.nextLine();
                String playerName = inp.nextLine();

                String playerFile = "Players\\" + playerName + ".txt";

                File player = new File(playerFile);

                if (player.exists()) {

                }
                else {
                    System.out.println();
                    System.out.println("Character does not exist!");
                    System.out.println();
                }

            }
        } while (choice != 3);

        System.out.println("\nThank you for playing!");

    }

    // Character Creation Sequence
    static void characterCreation() {
        // Choose race
        System.out.println("Welcome to the world of Victorias! To start off your journey, please choose a race: ");
        System.out.println();

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
        } while (playerRace == 4);

        // Choose name
        System.out.println();
        System.out.print("Enter your name: ");

        inp.nextLine();
        String playerName = inp.nextLine();

        // Write description
        System.out.println();
        System.out.println("Greetings, " + playerName + "! Now, give a short description about yourself: ");
        System.out.println();

        String playerBio = inp.nextLine();

        System.out.println();
        System.out.println("You're character has been born! You may now start your adventure through the world of Victorias with " + playerName + ".\n");

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
        NewPlayer newPlayer = new NewPlayer(playerName, playerRace, playerBio,
                playerMaxHealth, playerMaxMana,
                playerPhysicalAttack, playerMagicalAttack,
                playerPhysicalDefense, playerMagicalDefense);
    }
}
