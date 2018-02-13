/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon.dto;

import java.util.Random;

/**
 *
 * @author kmlnd
 */
public class Monster {

    private String name;
    private String weapon;
    private int HP;
    private int attackPoints;
    private int Exp;

    public String getName() {
        Random randomRoll = new Random();
        String[] names = {"Bandit", "Dragon", "Orc", "Titan", "Skeleton"};
        int HPMonsterGenerator = randomRoll.nextInt(names.length) + 0;
        String Monster = names[HPMonsterGenerator];
        name = Monster;
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {

        Random randomRoll = new Random();

        /*
            HP 3 - 7
         */
        if (name.equalsIgnoreCase("Dragon")) {
            HP = 10;
            return HP;
        } else {
            int HPMonsterGenerator = randomRoll.nextInt(7) + 3;
            HP = HPMonsterGenerator;
            return HP;
        }
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getAttackPoints() {
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
