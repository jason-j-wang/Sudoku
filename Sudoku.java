/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
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
    
    private boolean[][] filled = {
        {true, true, true, true, true, true, false, true, false},
        {true, true, false, true, false, true, true, false, true},
        {false, true, true, true, false, true, true, false, true},
        {true, true, false, false, false, true, false, false, false},
        {true, false, true, false, false, true, false, true, false},
        {true, false, false, true, false, true, true, false, false},
        {true, false, false, false, true, true, true, true, true},
        {true, false, true, true, false, false, true, true, true},
        {false, true, false, false, true, true, true, false, false}
    };
    
    public Sudoku(){
        super("Sudoku");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(new GridLayout(ROW, COL));
        JPanel messagePanel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        
        buttons = new Button[ROW * ROW][COL * COL];
        for (int i = 0; i < ROW; i++){
            for (int j = 0; j < COL; j++){
                JPanel gridPanel = new JPanel();
                gridPanel.setLayout(new GridLayout(ROW, COL));
                gridPanel.setBorder(blackline);
                
                for (int r = 0; r < ROW; r++){
                    for (int c = 0; c < COL; c++){
                        Button b = new Button();
                        gridPanel.add(b);
                        //buttons[i * r][j * c] = b; fix
                        
                    }
                }
                masterPanel.add(gridPanel);
            }
        }
        
        masterPanel.setBorder(blackline);  
        
        this.add(messagePanel);
        this.add(masterPanel);
        this.pack();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        Sudoku game = new Sudoku();
        
           
        }
    }
    

