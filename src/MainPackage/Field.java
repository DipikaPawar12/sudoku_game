/*
 * This file generates the field of size 9X9 of the sudoku game 
 */

package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import static javax.swing.SwingConstants.CENTER;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Field extends JLabel {
    public static int[][] black;
    private int x;      // X position in game.
    private int y;      // Y position in game.

   
    public Field(int x, int y) {
        super("", CENTER);
        this.x = x;
        this.y = y;
        black = new int[9][9];
        
        
        setPreferredSize(new Dimension(40, 40));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        setOpaque(true);
    }
    
    public Field(){
        black = new int[9][9];
    }

   
    public void setNumber(int number, boolean userInput) {
       // setForeground(userInput ? Color.BLUE : Color.BLACK);
        setText(number > 0 ? number + "" : "");
        if(userInput){
            setForeground(Color.BLUE);
            black[y][x]=0;
            //System.out.println("Blue");
        }else{
            black[y][x]=number;
            setForeground( Color.BLACK );
        }

    }

    
    public int getFieldX() {
        return x;
    }

   
    public int getFieldY() {
        return y;
    }
    
}
