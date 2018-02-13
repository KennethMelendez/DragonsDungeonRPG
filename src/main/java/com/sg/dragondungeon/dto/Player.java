/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon.dto;

/**
 *
 * @author kmlnd
 */
public class Player {

    private String name;
    private String weapon;
    private int attackPoints;
    private int Exp;
    private boolean gameOver;

    /*==========================================================
    
      *  Player name is a unique identifier for the Player  *
    
    ====================
         Weapons
    ====================
    
     Crossbow: +3 on attack
     Flail: +4 on attack
     Broad Sword: +5 on attack
     Dragon Slayer: +6 on attack
     Spell of The Gods: +7 on attack
    
    ===========================================================*/
    public Player(String name) {
        this.name = name;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getAttackPoints() {

        switch (weapon) {

            case "crossbow":
                attackPoints = 3;
                break;
            case "flail":
                attackPoints = 4;
                break;
            case "broad sword":
                attackPoints = 5;
                break;
            case "dragon slayer":
                attackPoints = 6;
                break;
            case "spell of the gods":
                attackPoints = 7;
                break;
            case "fists":
                attackPoints = 1;
                break;
        }

        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int Exp) {
        this.Exp = Exp;
    }

}
