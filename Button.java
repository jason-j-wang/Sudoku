/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 *
 * @author j02.wang
 */
public class Button extends JButton {
    
    private int number;
    private int playerNumber;
    private boolean visible;
    private boolean selected;
    
    public Button(int num, boolean vis){
        number = num;
        visible = vis;
        
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(Color.white);
        this.setFont(new Font(Font.SERIF, Font.BOLD, 35));

        
        Border buttonBorder = BorderFactory.createLineBorder(Color.darkGray);
        this.setBorder(buttonBorder);
        
        if (visible){
            this.setText(String.valueOf(number));
            this.setBackground(Color.lightGray);
            playerNumber = num;
  
            
        } 
    }
    public void enterText(String num){
        try{
            this.playerNumber = Integer.parseInt(num);
            if (playerNumber == 0){
                throw new Exception();
            }
            this.setText(num);
            
        } catch(Exception err){
            
        }
        
    }
    
    public boolean isShown(){
        return this.visible;
    }
    
    public int getValue(){
        return this.number;
    }   
    
    public int getPlayerValue(){
        return this.playerNumber;
    }
    
    public void select(){
        this.selected = true;
        if (!visible){
            this.setBackground(Color.cyan);
        }
    }
    
    public void deselect(){
        this.selected = false;
        if (!visible){
            this.setBackground(Color.white);
        }
        
    }
    
}
