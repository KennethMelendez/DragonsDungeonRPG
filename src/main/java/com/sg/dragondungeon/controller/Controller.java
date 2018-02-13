/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon.controller;

import com.sg.dragondungeon.dao.PersistenceException;
import com.sg.dragondungeon.dao.dao;
import com.sg.dragondungeon.dto.Monster;
import com.sg.dragondungeon.dto.Player;
import com.sg.dragondungeon.ui.UserIO;
import com.sg.dragondungeon.ui.View;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class Controller {

    View view;
    dao leaderBoard;

    public Controller(View view,dao leaderBoard) {
        this.view = view;
        this.leaderBoard = leaderBoard;
    }

    String[] gameSteps = {"*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*", "*",};
    Random randomRoll = new Random();
    boolean youWin = false;
    int playerSteps = gameSteps.length;
    String setPlayersStartWeapon = "broad sword";

    public void run() {

/*==================================================================================================================================
        
        
                    Dragons Dungeon
        
        
                        "Deep in the Dragons Dungeon, there exists an artifact that will bring you everlasting wisdom."
                        "Will you be the one to retrive it...?"
        

==================================================================================================================================*/

// Introduction and character creation.

        try {
            introduction();
            String name = promptName();
            Player Silentprotagonist = new Player(name);
            Silentprotagonist.setWeapon(setPlayersStartWeapon);

/*==================================================================================================================================
                   Game Logic Map progression
==================================================================================================================================*/

// For loop that loops through each step and progression of the game.

            for (int x = 0; x <= playerSteps; x++) {

                displayMap(gameSteps);

                if (Silentprotagonist.isGameOver() == true) {
                    GameOverMessage();
                    break;
                } else if (x >= playerSteps - 2) {
                    youWin = true;
                    congratulationsWinnerMessage();
                } else if (x == randomizerSpawner(gameSteps)) {
                    view.battleArena(Silentprotagonist, view.monsterSpawner());
                } else {
                    int steps = view.playerMenuDismountOptions(Silentprotagonist);
                    x += steps;
                    if (x <= gameSteps.length - 1) {
                        gameSteps[x] = "((o))";
                    }
                }

                youTookThisManyStepsDisplay(x);
            } // end of for loop
            if (youWin == true) {
                congratulationsWinnerMessage();
            }
            
            leaderBoard.addscoreBoard(Silentprotagonist.getName(), Silentprotagonist);
            List<Player> scoreList = leaderBoard.viewLeaderBoard();
            view.viewLeaderboard(scoreList);
        } catch (PersistenceException ex) {
            view.displayInGameMsg(ex.getMessage());
        }

    }

    private int randomizerSpawner(String[] map) {

        /*
        
        Change the method so that it randomly spawns
        monsters on each random array before the game loads
        
        
         */
        return randomRoll.nextInt(map.length - 1) + 1;
    }

    private void introduction() throws PersistenceException {
        view.introScreen();
        view.mainMenu();
    }

    private String promptName() throws PersistenceException {
        return view.promptName();
    }

    private void displayMap(String gameSteps[]) {
        view.displayMap(gameSteps);
    }

    private void GameOverMessage() {
        view.displayInGameMsg("Game Over...you were overwhelmed..");
    }

    private void congratulationsWinnerMessage() {
        view.displayInGameMsg("You found the ancient artifact, You win congratulations!!!!");
    }

    private void youTookThisManyStepsDisplay(int x) {
        view.displayInGameMsg("You took this many steps.. " + x);
    }
}
