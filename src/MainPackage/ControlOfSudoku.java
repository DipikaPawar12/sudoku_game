/*
 * This file contains all the control of the sudoku game.
 */

package MainPackage;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class ControlOfSudoku implements MouseListener {
    private MainPanel sudokuPanel;    
    private MakeGame game;                 

   
    public ControlOfSudoku(MainPanel sudokuPanel, MakeGame game) {
        this.sudokuPanel = sudokuPanel;
        this.game = game;
    }

    
    public void mousePressed(MouseEvent e) {
        JPanel panel = (JPanel)e.getSource();
        Component component = panel.getComponentAt(e.getPoint());
        if (component instanceof Field) {
            Field field = (Field)component;
            int x = field.getFieldX();
            int y = field.getFieldY();

            if (e.getButton() == MouseEvent.BUTTON1 && (game.getNumber(x, y) == 0 || field.getForeground().equals(Color.BLUE))) {
                int number = game.getSelectedNumber();
                if (number == -1)
                    return;
                game.setNumber(x, y, number);
                field.setNumber(number, true);
            } else if (e.getButton() == MouseEvent.BUTTON3 && !field.getForeground().equals(Color.BLACK)) {
                game.setNumber(x, y, 0);
                field.setNumber(0, false);
            }
            sudokuPanel.update(game, UpdateAction.CANDIDATES);
        }
    }

    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    
}
