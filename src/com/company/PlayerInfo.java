package com.company;

public class PlayerInfo {

    // Basic Stats
    private String playerName;
    private String playerRace;
    private String playerBio;

    // Combat Stats
    private int playerMaxHealth;
    private int playerHealth;
    private int playerMaxMana;
    private int playerMana;
    private int playerPhysicalAttack;
    private int playerMagicalAttack;
    private int playerPhysicalDefense;
    private int playerMagicalDefense;

    // Experience
    private int playerLevel;
    private int playerMaxXP;
    private int playerXP;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public String getPlayerBio() {
        return playerBio;
    }

    public void setPlayerBio(String playerBio) {
        this.playerBio = playerBio;
    }

    public int getPlayerMaxHealth() {
        return playerMaxHealth;
    }

    public void setPlayerMaxHealth(int playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getPlayerMaxMana() {
        return playerMaxMana;
    }

    public void setPlayerMaxMana(int playerMaxMana) {
        this.playerMaxMana = playerMaxMana;
    }

    public int getPlayerMana() {
        return playerMana;
    }

    public void setPlayerMana(int playerMana) {
        this.playerMana = playerMana;
    }

    public int getPlayerPhysicalAttack() {
        return playerPhysicalAttack;
    }

    public void setPlayerPhysicalAttack(int playerPhysicalAttack) {
        this.playerPhysicalAttack = playerPhysicalAttack;
    }

    public int getPlayerMagicalAttack() {
        return playerMagicalAttack;
    }

    public void setPlayerMagicalAttack(int playerMagicalAttack) {
        this.playerMagicalAttack = playerMagicalAttack;
    }

    public int getPlayerPhysicalDefense() {
        return playerPhysicalDefense;
    }

    public void setPlayerPhysicalDefense(int playerPhysicalDefense) {
        this.playerPhysicalDefense = playerPhysicalDefense;
    }

    public int getPlayerMagicalDefense() {
        return playerMagicalDefense;
    }

    public void setPlayerMagicalDefense(int playerMagicalDefense) {
        this.playerMagicalDefense = playerMagicalDefense;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerMaxXP() {
        return playerMaxXP;
    }

    public void setPlayerMaxXP(int playerMaxXP) {
        this.playerMaxXP = playerMaxXP;
    }

    public int getPlayerXP() {
        return playerXP;
    }

    public void setPlayerXP(int playerXP) {
        this.playerXP = playerXP;
    }

}

interface Save {
    public void writeToPlayerFile(String playerName);
}