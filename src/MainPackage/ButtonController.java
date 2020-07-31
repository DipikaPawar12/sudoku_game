/*
 * This is for having the controls of all the buttons made.
 */

package MainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileWriter;
import javax.swing.JOptionPane;
import MainPackage.ButtonPanel.TestPane;


public class ButtonController implements ActionListener {

    private MakeGame game1;

    //MakeGame main=new MakeGame(0);
    
    public ButtonController(MakeGame game2) {
        this.game1 = game2;
    }

    
    public static boolean f;

    public void actionPerformed(ActionEvent e) {
        MenuScreen ms = new MenuScreen();
        ButtonPanel bp;
        if (e.getActionCommand().equals("New")) {
            game1.newGame();
            f = false;
            ButtonPanel.count = 0;
        } else if (e.getActionCommand().equals("Check")) {
            game1.checkGame();
        } else if (e.getActionCommand().equals("Exit")) {
            ms.setVisible(true);
            MenuScreen.s.setVisible(false);
            //  Sudoku.setVisible(false);
        } else if (e.getActionCommand().equals("Finish")) {
            //f = game1.finish(true);
            boolean flag = game1.correctSol();
            ScoreNeed s = new ScoreNeed();
            if (flag) {
                game1.checkGame();
                s.setVisible(true);
                 MenuScreen.s.setVisible(false);
                f=true;
            } else {
                JOptionPane.showConfirmDialog(null, "You can't finish game.(Incomplete/wrong solution)", "Incorrect Game", 2, 0);
            }
        } else if (e.getActionCommand().equals("Save")) {
            fileWrite();
           // System.out.println("Success...");
             JOptionPane.showMessageDialog(null, "Your game has been sucessfully saved!", "Saved", 1);
            ms.setVisible(true);
            MenuScreen.s.setVisible(false);

        } else if (e.getActionCommand().equals("Help on")) {
            game1.setHelp(((JCheckBox) e.getSource()).isSelected());
        } else {
            game1.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
        }
    }

    void fileWrite() {
        int[][] black = Field.black;
        try {
            FileWriter fw = new FileWriter("src/sudoku/testout.txt");
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    fw.write(black[y][x]+ "");
                }
            }
            fw.write("\n");
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    fw.write(MakeGame.getSolNumber(x, y) + "");
                }
            }
            fw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
