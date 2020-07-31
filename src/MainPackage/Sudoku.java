/*
 * This file has all the other files linked so that the file runs in a smooth flow.
 */

package MainPackage;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Sudoku extends JFrame{
   public Sudoku() {
       this.setTitle("MAD at Sudoku");
        
        Image icon = Toolkit.getDefaultToolkit().getImage("src/sudoku/icon image.jpg");
        this.setIconImage(icon);
         this.getContentPane().setBackground(Color.WHITE);
       // super("Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        MakeGame game = new MakeGame();

        ButtonController buttonController = new ButtonController(game);
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setController(buttonController);
        add(buttonPanel, BorderLayout.EAST);

        MainPanel sudokuPanel = new MainPanel();
        ControlOfSudoku sudokuController = new ControlOfSudoku(sudokuPanel, game);
        sudokuPanel.setGame(game);
        sudokuPanel.setController(sudokuController);
        add(sudokuPanel, BorderLayout.CENTER);
       
        game.addObserver(buttonPanel);
        game.addObserver(sudokuPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    } 
   public Sudoku(MakeGame g) {
        super("Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

       // MakeGame game = new MakeGame();

        ButtonController buttonController = new ButtonController(g);
        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setController(buttonController);
        add(buttonPanel, BorderLayout.EAST);

        MainPanel sudokuPanel = new MainPanel();
        ControlOfSudoku sudokuController = new ControlOfSudoku(sudokuPanel, g);
        sudokuPanel.setGame(g);
        sudokuPanel.setController(sudokuController);
        add(sudokuPanel, BorderLayout.CENTER);
       
        g.addObserver(buttonPanel);
        g.addObserver(sudokuPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    } 
   
    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ex) { ex.printStackTrace(); }
        new Sudoku();
    }
}
