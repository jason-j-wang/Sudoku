/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author j02.wang
 */
public class Button extends JButton {
    
    public Button(){
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.white);
    }
    
}
