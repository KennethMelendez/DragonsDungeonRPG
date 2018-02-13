/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dragondungeon;

import com.sg.dragondungeon.controller.Controller;
import com.sg.dragondungeon.ui.UserIO;
import com.sg.dragondungeon.ui.UserIOImpl;
import com.sg.dragondungeon.ui.View;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        View view = new View(io);
        Controller controller = new Controller(view , io);
        controller.run();
    }
}
