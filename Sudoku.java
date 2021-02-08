/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.Border;


/**
 *
 * @author j02.wang
 */
public class Sudoku extends JFrame {
    
    private static int ROW = 3;
    private static int COL = 3;
    private Button[][] buttons;
    private Button currentButton;
    private boolean completed;
    private JLabel message;
    
    
    private int[][] board = {
        {9, 2, 8, 7, 3, 4, 5, 1, 6},
        {4, 6, 5, 8, 9, 1, 3, 7, 2},
        {3, 1, 7, 6, 5, 2, 8, 4, 9},
        {1, 7, 9, 5, 4, 3, 2, 6, 8},
        {6, 3, 4, 2, 7, 8, 9, 5, 1},
        {8, 5, 2, 9, 1, 6, 4, 3, 7},
        {2, 4, 3, 1, 6, 9, 7, 8, 5},
        {5, 8, 6, 3, 2, 7, 1, 9, 4},
        {7, 9, 1, 4, 8, 5, 6, 2, 3}
    };
    
    /*private boolean[][] filled = {
        {true, true, true, true, true, true, false, true, false},
        {true, true, false, true, false, true, true, false, true},
        {false, true, true, true, false, true, true, false, true},
        {true, true, false, false, false, true, false, false, false},
        {true, false, true, false, false, true, false, true, false},
        {true, false, false, true, true, true, true, false, false},
        {true, false, false, false, true, true, true, true, true},
        {true, false, true, true, false, false, true, true, true},
        {false, true, false, false, true, true, true, false, false}
    }; */
    
    private boolean[][] filled = {
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, true},
        {true, true, true, true, true, true, true, true, false}
    };
    
    public Sudoku(){
        super("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        completed = false;
        
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new GridLayout(ROW, COL));
        JPanel messagePanel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        buttons = new Button[ROW * ROW][COL * COL];
        for (int outerRow = 0; outerRow < ROW; outerRow++){
            for (int outerCol = 0; outerCol < COL; outerCol++){
                JPanel gridPanel = new JPanel();
                gridPanel.setLayout(new GridLayout(ROW, COL));
                gridPanel.setBorder(blackline);
                
                for (int innerRow = 0; innerRow < ROW; innerRow++){
                    for (int innerCol = 0; innerCol < COL; innerCol++){
                        int num = board[outerRow * 3 + innerRow][outerCol * 3 + innerCol];
                        boolean visible = filled[outerRow * 3 + innerRow][outerCol * 3 + innerCol];
                        Button b = new Button(num, visible);
                        gridPanel.add(b);
                        buttons[outerRow * 3 + innerRow][outerCol * 3 + innerCol] = b;
                        
                        b.addActionListener(new ClickHandler(this));
                        if (!visible){
                            b.addKeyListener(new KeyboardInput(this));
                        }
                        
                    }
                }
                masterPanel.add(gridPanel);
            }
        }
        masterPanel.setBorder(blackline);  
        
        message = new JLabel();
        message.setText("Solve the Sudoku");
        messagePanel.add(message);

        
        this.add(messagePanel, BorderLayout.NORTH);
        this.add(masterPanel, BorderLayout.SOUTH);
        this.pack();
        
    }
    
    public void setCurrentButton(Button b){
        if (currentButton != null){
            currentButton.deselect();
        }
        currentButton = b;
        b.select();
    }
    
    public Button getCurrentButton(){
        return currentButton;
    }
    
    public boolean isCompleted(){
        boolean win = true;
        for (int i = 0; i < COL * COL; i++){
            for (int j = 0; j < ROW * ROW; j++){
                Button b = buttons[i][j];
                if (b.getValue() != b.getPlayerValue()){
                    win = false;
                    
                }
            }
        }
        if (win){
            completed = true;
        }

        return win;
    }
    
    public void checkIfWon(){
        if (isCompleted()){
            message.setText("Victory Royale!");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Sudoku game = new Sudoku();
           
        }
    }
    

