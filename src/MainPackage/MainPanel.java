/*
 * This file generates the main game panel with sudoku field and button options.
 */

package MainPackage;

import MainPackage.Field;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class MainPanel extends JPanel implements Observer{
    private static final Color COLOR_CANDIDATE = new Color(102, 153, 255);

    private Field[][] fields;       
    private JPanel[][] panels;      

    
    public MainPanel() {
        super(new GridLayout(3, 3));
        
        panels = new JPanel[3][3];
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                panels[y][x] = new JPanel(new GridLayout(3, 3));
                panels[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                add(panels[y][x]);
            }
        }

        fields = new Field[9][9];
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x] = new Field(x, y);
                panels[y / 3][x / 3].add(fields[y][x]);
            }
        }
    }

   
    public void update(Observable o, Object arg) {
        switch ((UpdateAction)arg) {
            case NEW_GAME:
                setGame((MakeGame)o);
                break;
            case CHECK:
                setGameCheck((MakeGame)o);
                break;
            case SELECTED_NUMBER:
            case CANDIDATES:
            case HELP:
                setCandidates((MakeGame)o);
                break;
        }
    }

    
    public void setGame(MakeGame game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.WHITE);
                fields[y][x].setNumber(game.getNumber(x, y), false);
            }
        }
    }

   
    private void setGameCheck(MakeGame game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.WHITE);
                if (fields[y][x].getForeground().equals(Color.BLUE))
                    fields[y][x].setBackground(game.isCheckValid(x, y) ? Color.GREEN : Color.RED);
            }
        }
    }

   
    private void setCandidates(MakeGame game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.WHITE);
                if (game.isHelp() && game.isSelectedNumberCandidate(x, y))
                    fields[y][x].setBackground(COLOR_CANDIDATE);
            }
        }
    }

   
    public void setController(ControlOfSudoku sudokuController) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++)
                panels[y][x].addMouseListener((MouseListener) sudokuController);
        }
    }
}
