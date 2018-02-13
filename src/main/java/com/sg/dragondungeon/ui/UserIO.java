/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon.ui;

import com.sg.dragondungeon.dao.PersistenceException;

/**
 *
 * @author kmlnd
 */
public interface UserIO {

    void displayMessage(String msg);
    
    void displayMsgHorizontally(String msg);

    String promptName() throws PersistenceException;

    String promptUserIOString(String msg) throws PersistenceException;
    
    int promptInt(String msg)throws PersistenceException ;
}
