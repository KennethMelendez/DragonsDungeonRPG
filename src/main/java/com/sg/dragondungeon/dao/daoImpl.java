package com.sg.dragondungeon.dao;

import com.sg.dragondungeon.dto.Player;
import static java.awt.Event.SAVE_FILE;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kmlnd
 */
public class daoImpl implements dao {

    private Map<String, Player> LeaderBoard = new HashMap<>();
    private static final String SAVES_FILE = "saves.txt";
    private static final String DELIMETER = "::";

    @Override
    public void addscoreBoard(String playerName, Player currentPlayer) throws PersistenceException {
        LoadGameBoard();
        LeaderBoard.put(playerName, currentPlayer);
        saveGameBoard();

    }

    @Override
    public List<Player> viewLeaderBoard() {
        return new ArrayList<>(LeaderBoard.values());
    }

    public void saveGameBoard() throws PersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(SAVES_FILE));
        } catch (IOException e) {
            throw new PersistenceException("Error Saving file", e);
        }

        List<Player> playerList = this.viewLeaderBoard();

        for (Player currentPlayer : playerList) {
            out.println(currentPlayer.getName() + DELIMETER
                    + currentPlayer.getWeapon() + DELIMETER
                    + currentPlayer.getExp());
            //force printwriter to write line to the file
            out.flush();
        }
        //clean up
        out.close();

    }

    public void LoadGameBoard() throws PersistenceException {

        Scanner scanner;
        try {

            scanner = new Scanner(new BufferedReader(new FileReader(SAVES_FILE)));
        } catch (FileNotFoundException ex) {
            throw new PersistenceException("Could not load save file", ex);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);

            Player currentPlayer = new Player(currentTokens[0]);
            currentPlayer.setWeapon(currentTokens[1]);
            currentPlayer.setExp(Integer.parseInt(currentTokens[2]));

            LeaderBoard.put(currentPlayer.getName(), currentPlayer);
        }

        scanner.close();
    }

}
