package com.sg.dragondungeon.dao;

import com.sg.dragondungeon.dto.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kmlnd
 */
public class daoImpl implements dao{

    private Map<String, Player> LeaderBoard = new HashMap<>();
    
    @Override
    public void addscoreBoard(String playerName, Player currentPlayer) {
        LeaderBoard.put(playerName, currentPlayer);
    }

    @Override
    public List<Player> viewLeaderBoard() {
       return new ArrayList<>(LeaderBoard.values());
    }
    
}
