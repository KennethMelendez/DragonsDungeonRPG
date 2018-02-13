/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon.ui;

import com.sg.dragondungeon.dao.PersistenceException;
import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class UserIOImpl implements UserIO {

    Scanner videoGameMessageScanner = new Scanner(System.in);

    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public String promptName() throws PersistenceException {
        boolean isName = true;
        String result = "";
        while (isName == true && "".equals(result) || result == null) {
            try {
                this.displayMessage("What is your name young warrior..?");
                result = videoGameMessageScanner.nextLine();

            } catch (Exception e) {
                throw new PersistenceException("Invalid Input.", e);
            }
        }

        return result;
    }

    @Override
    public String promptUserIOString(String msg) throws PersistenceException {
        String result = "";
        try {
            displayMessage(msg);
            result = this.videoGameMessageScanner.nextLine();
        } catch (Exception e) {
            throw new PersistenceException("Invalid Input.", e);
        }
        return result;
    }

    @Override
    public int promptInt(String msg) throws PersistenceException {
        String result = "";
        int response;
        try {
            displayMessage(msg);
            
            result = this.videoGameMessageScanner.nextLine();
            response = Integer.parseInt(result);
        } catch (Exception e) {
            throw new PersistenceException("Invalid Input.", e);
        }
        return response;
    }

    @Override
    public void displayMsgHorizontally(String msg) {
        System.out.print(msg);
    }

}
