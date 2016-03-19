/****************************************************************************
*   ControlPanel.java                                                       *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   creates a panel that will added to the form                             *
*   handles the buttons for new, restart, and exit                          *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
    
    // variables
    
    // GUI components for the panel
    private JButton btnNewGame = new JButton("New Game");
    private JButton btnRestartGame = new JButton("Restart Game");
    private JButton btnExitGame = new JButton("Exit Game");
    private JPanel pnlControl = new JPanel();
    private ButtonHandler bh = new ButtonHandler();
    private GamePanel gamePanel;
    private StatusPanel statusPanel;
    
    
    // constructors
    public ControlPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        pnlControl.setLayout(new GridLayout(1,3,3,3));
        btnNewGame.addActionListener(bh);
        pnlControl.add(btnNewGame);
        btnRestartGame.addActionListener(bh);
        pnlControl.add(btnRestartGame);
        btnExitGame.addActionListener(bh);
        pnlControl.add(btnExitGame);
        
        statusPanel = new StatusPanel();
        statusPanel.stopUpdateScoreTimer();
    } // end no-arg constructor

    // get panel object
    public JPanel getPnlControl(){
        return pnlControl;
    } // end getPnlControl
    
    // action listener for the buttons
    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btnPushed = (JButton)e.getSource();
            
            if (btnPushed.getText().equals("New Game")) {
                statusPanel.setPointsEarned(0);
                gamePanel.requestFocus();
            } // end if
            else if(btnPushed.getText().equals("Restart Game")) {
                statusPanel.setPointsEarned(0);
                gamePanel.requestFocus();
            } // end else if
            else {
                System.exit(0);
            } // end else
        } // end actionPerformed
    } // end class Button Handler
} // end class ControlPanel
