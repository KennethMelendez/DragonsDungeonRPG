/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon.dao;

import com.sg.dragondungeon.dto.Player;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface dao {
     void addscoreBoard(String playerName, Player currentPlayer);
     List<Player> viewLeaderBoard();
}
