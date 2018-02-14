/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon.ui;

import com.sg.dragondungeon.dao.PersistenceException;
import com.sg.dragondungeon.dto.Monster;
import com.sg.dragondungeon.dto.Player;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kmlnd
 */
public class View {

    UserIO io;

    public View(UserIO io) {
        this.io = io;
    }

    public void introScreen() throws PersistenceException {
        io.displayMessage("Deep in the Dragons Dungeon, there exists an artifact that will bring you everlasting wisdom.");
        io.displayMessage("Will you be the one to retrive it...?");
        this.hitEnterToContinue();
    }

    public void mainMenu() throws PersistenceException {

        io.displayMessage("           .-.---------------------------------.-.\n"
                + "          ((o))                                   )\n"
                + "           \\U/_______          _____         ____/\n"
                + "             |                                  |\n"
                + "             |                                  |\n"
                + "             |                                  |\n"
                + "             |      Welcome to..                |\n"
                + "             |         The Dragons Dungeon      |\n"
                + "             |                                  |\n"
                + "             |                                  |\n"
                + "             |                                  |\n"
                + "             |    Press Enter to Start.         |\n"
                + "             |                                  |\n"
                + "             |                                  |\n"
                + "             |____    _______    __  ____    ___|KCK\n"
                + "            /A\\                                  \\\n"
                + "           ((o))                                  )\n"
                + "            '-'----------------------------------'");
        this.hitEnterToContinue();

    }

    public void displayMap(String gameSteps[]) {
        io.displayMessage("In-game map");

        io.displayMsgHorizontally("Player(o)");

        for (String map : gameSteps) {

            io.displayMsgHorizontally(map);
        }

        io.displayMsgHorizontally("(X) Exit\n");
    }

    public String promptName() throws PersistenceException {
        return io.promptName();
    }

    public void displayInGameMsg(String msg) {
        io.displayMessage(msg);
    }

    public void hitEnterToContinue() throws PersistenceException {
        io.promptUserIOString("Hit enter to continue.");
    }

    public int sixSidedDiceRoll() {
        Random randomRoll = new Random();
        int numberGenerator = randomRoll.nextInt(6) + 0;
        return numberGenerator;
    }

    public int playerMenuDismountOptions(Player main) throws PersistenceException {
        io.displayMessage("You look around...\nWhat would you like to do...?");
        io.displayMessage("1. Keep Traveling?");
        io.displayMessage("2. Explore the current area?");
        int response;
        int keepMoving = 0;
        response = io.promptInt("Input number.");

        switch (response) {
            case 1:
                keepMoving = sixSidedDiceRoll();
                break;
            case 2:
                explore(main);
                break;
            default:
                io.displayMessage("Invalid input");
        }
        return keepMoving;
    }

    public Player explore(Player main) throws PersistenceException {

        Random randomRoll = new Random();
        int exploringResultGenerator = randomRoll.nextInt(3) + 1;

        switch (exploringResultGenerator) {
            case 1:
                main = battleArena(main, this.monsterSpawner());
                break;
            case 2:
                String newWeapon = weaponSpawner();
                main.setWeapon(newWeapon);
                io.displayMessage("You found the " + main.getWeapon().toUpperCase() + "\n Your attack damage is " + main.getAttackPoints());
                break;
            case 3:
                io.displayMessage("Nothing was found....");
                break;

        }
        return main;
    }

    public Monster monsterSpawner() {
        Monster monsterSpawner = new Monster();
        return monsterSpawner;
    }

    public String weaponSpawner() {
        Random randomRoll = new Random();
        //int weaponSpawner = randomRoll.nextInt(4) + 0;
        int weaponSpawner = randomRoll.nextInt(4);
        String[] weapons = {"crossbow", "flail", "broad sword", "dragon slayer", "spell of the gods"};
        return weapons[weaponSpawner];
    }

    public Player battleArena(Player main, Monster currentMonster) throws PersistenceException {
        io.displayMessage("");
        io.displayMessage("******* BATTLE MODE *******");
        io.displayMessage("");
       // int attackBoost = sixSidedDiceRoll();
        int playersAttack = main.getAttackPoints();

        main.setAttackPoints(playersAttack);
        io.displayMessage("You encountered a monster!!!");
        io.displayMessage("You ready your weapon...");
        io.displayMessage(main.getName() + " has " + main.getAttackPoints() + " attack points.");
        io.displayMessage(main.getName() + " Attacked! ");
        this.hitEnterToContinue();
        io.displayMessage(currentMonster.getName() + " Attacked! ");
        if (main.getAttackPoints() > currentMonster.getHP()) {
            io.displayMessage("You survived!!");
            int exp = main.getExp();

            main.setExp(exp += 2);
        } else {
            main.setGameOver(true);

        }
        return main;
    }

    public void viewLeaderboard(List<Player> leaderBoard) {
        io.displayMessage("");
        io.displayMessage(" === SCORE === ");
        for (Player display : leaderBoard) {
            io.displayMessage("| Hero : " + display.getName() + " | Weapon used : " + display.getWeapon() + " | SCORE/EXP : " + display.getExp());
            io.displayMessage("");
        }
    }
}
