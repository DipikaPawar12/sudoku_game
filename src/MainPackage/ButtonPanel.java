/*
 * This is for generating all the buttons needed for the game.
 */
package MainPackage;

import static MainPackage.ButtonController.f;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



public class ButtonPanel extends JPanel implements Observer {

    JButton btnNew, btnCheck, btnExit, btnSave, btnFinish;   
    JCheckBox cbHelp;               
    ButtonGroup bgNumbers;          
    JToggleButton[] btnNumbers;    

   
    public ButtonPanel() {
        super(new BorderLayout());

        JPanel pnlAlign = new JPanel();
        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign, BorderLayout.NORTH);

        JPanel pnlOptions = new JPanel(new FlowLayout(FlowLayout.LEADING));
       // pnlOptions.setFont(new Font("Tahoma",Font.BOLD,24));
       // pnlOptions.setForeground(new Color(0,0,102));
        pnlOptions.setBorder(BorderFactory.createTitledBorder(" Options "));
      //  pnlOptions.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pnlAlign.add(pnlOptions);

        btnNew = new JButton("New");
        btnNew.setFocusable(false);
        btnNew.setFont(new Font("Tahoma",Font.BOLD,16));
        btnNew.setForeground(new Color(0,0,102));
        pnlOptions.add(btnNew);
        

        btnCheck = new JButton("Check");
        btnCheck.setFocusable(false);
        btnCheck.setFont(new Font("Tahoma",Font.BOLD,16));
        btnCheck.setForeground(new Color(0,0,102));
      //  btnCheck.setBorder(new LineBorder(new Color(0,0,102),1));
        pnlOptions.add(btnCheck);

        btnExit = new JButton("Exit");
        btnExit.setFocusable(false);
        btnExit.setFont(new Font("Tahoma",Font.BOLD,16));
        btnExit.setForeground(new Color(0,0,102));
        pnlOptions.add(btnExit);

        btnSave = new JButton("Save");
        btnSave.setFocusable(false);
        btnSave.setFont(new Font("Tahoma",Font.BOLD,16));
        btnSave.setForeground(new Color(0,0,102));
        pnlOptions.add(btnSave);

        JPanel pnlNumbers = new JPanel();
        pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.PAGE_AXIS));
        pnlNumbers.setBorder(BorderFactory.createTitledBorder(" Numbers "));
        pnlAlign.add(pnlNumbers);

        JPanel pnlTimer = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlTimer.setBorder(BorderFactory.createTitledBorder("Timer"));
        pnlAlign.add(pnlTimer);
       // pnlAlign.add(pnlTimer);
        TestPane tp=new TestPane(pnlTimer);
        

            JPanel pnlNumbersHelp = new JPanel(new FlowLayout(FlowLayout.LEADING));

            pnlNumbers.add (pnlNumbersHelp);

            cbHelp  = new JCheckBox("Help on", true);
            cbHelp.setFocusable (false);
            cbHelp.setFont(new Font("Tahoma",Font.BOLD,16));
            cbHelp.setForeground(new Color(0,0,102));
            pnlNumbersHelp.add (cbHelp);

            btnFinish  = new JButton("Finish");
            btnFinish.setFocusable (false);
            btnFinish.setFont(new Font("Tahoma",Font.BOLD,16));
            btnFinish.setForeground(new Color(0,0,102));
            pnlOptions.add (btnFinish);

            JPanel pnlNumbersNumbers = new JPanel(new FlowLayout(FlowLayout.LEADING));

            pnlNumbers.add (pnlNumbersNumbers);

            bgNumbers  = new ButtonGroup();
            btnNumbers  = new JToggleButton[9];
            for (int i = 0;
            i< 9; i

            
                ++) {
            btnNumbers[i] = new JToggleButton("" + (i + 1));
                btnNumbers[i].setPreferredSize(new Dimension(40, 40));
                btnNumbers[i].setFocusable(false);
                btnNumbers[i].setFont(new Font("Tahoma",Font.BOLD,12));
                btnNumbers[i].setForeground(new Color(0,0,102));
                bgNumbers.add(btnNumbers[i]);
                pnlNumbersNumbers.add(btnNumbers[i]);
            }
        }
       
    public void update(Observable o, Object arg) {
        switch ((UpdateAction) arg) {
            case NEW_GAME:
            case CHECK:
                bgNumbers.clearSelection();
                break;
        }
    }

    
    public void setController(ButtonController buttonController) {
        btnNew.addActionListener(buttonController);
        btnCheck.addActionListener(buttonController);
        btnExit.addActionListener(buttonController);
        btnSave.addActionListener(buttonController);
        btnFinish.addActionListener(buttonController);
        cbHelp.addActionListener(buttonController);
        for (int i = 0; i < 9; i++) {
            btnNumbers[i].addActionListener(buttonController);
        }
    }
    public static int count;
    
    static class TestPane  extends JLabel{
            JLabel label;
            Timer timer;
            public TestPane(JPanel pnlTimer) {
                count=0;
                label = new JLabel("...");
                pnlTimer.add(label);
                timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        count++;
                        if (!f) {
                            label.setText(Integer.toString(count));
                        } else {
                            ((Timer) (e.getSource())).stop();
                        }
                    }
                });
                timer.setInitialDelay(0);
                timer.start();
            }
        }
}
