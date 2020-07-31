/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import static MainPackage.ButtonPanel.count;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Observable;


/**
 *
 * @author DIPIKA PAWAR
 */
public class Sudoku extends Observable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
             BufferedWriter out = new BufferedWriter(new FileWriter("F:\\study_materials\\sem-3\\DSLab\\name.txt", true)); 
            out.write("dip");
            out.write("\n");
            out.write(count+"\n");
            out.close(); 
//            FileWriter fw = new FileWriter();
//            fw.write(s);
//            fw.write("\n"+count);
//            fw.write("\n");
            //fw.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
