/****************************************************************************
*   GameFrame.java                                                          *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*    the frame that will hold the game,status, and control panels           *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameFrame extends JFrame{
    
    

    // create status, game, and control panel objects
    private StatusPanel statusPanel = new StatusPanel();
    private GamePanel gamePanel = new GamePanel();
    private ControlPanel controlPanel = new ControlPanel(gamePanel);
    
    // GUI componets
    private Container contents;
    
    // constructors
    public GameFrame() {
        contents = getContentPane();
        contents.setLayout(new BorderLayout());
        contents.add(gamePanel,BorderLayout.CENTER);
        contents.add(statusPanel,BorderLayout.NORTH);
        contents.add(controlPanel.getPnlControl(),BorderLayout.SOUTH);
    } // end no-arg constructor

}  // end class GameFrame
