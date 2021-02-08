/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author j02.wang
 */
public class KeyboardInput implements KeyListener{
    
    Sudoku game;

    public KeyboardInput(Sudoku game){
        this.game = game;
}
    
    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (!game.isCompleted()){
            char key = ke.getKeyChar();
            Button b = game.getCurrentButton();
            b.enterText(Character.toString(key));
            game.checkIfWon();
        }
          
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
