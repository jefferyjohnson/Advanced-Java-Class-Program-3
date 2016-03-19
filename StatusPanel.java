/****************************************************************************
*   StatusPanel.java                                                        *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*    creates a panel that will be added to the form                         *
*    tracks the points earned for the game                                  *
*                                                                           *
****************************************************************************/
package spaceinvaders;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusPanel extends JPanel implements ActionListener{
    
    // variables 
    private static int pointsEarned; // holds value of points earned
    private Timer updateScoreTimer;  // to update score on screen
    
    // constructors
    public StatusPanel(){
        pointsEarned=+0;
        repaint();
        updateScoreTimer = new Timer(10,this);
        updateScoreTimer.start();
    }
    
    // getters and setters
    public static int getPointsEarned() {
        return pointsEarned;
    }

    public static void setPointsEarned(int aPointsEarned) {
        pointsEarned = aPointsEarned;
    }
    
    public static void addPointsEarned(int points){
        pointsEarned += points;
    }

    public Timer getUpdateScoreTimer() {
        return updateScoreTimer;
    }

    public void setUpdateScoreTimer(Timer updateScoreTimer) {
        this.updateScoreTimer = updateScoreTimer;
    }
    public void stopUpdateScoreTimer(){
        updateScoreTimer.stop();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Points: ", 300, 10);
        g.drawString(String.format("%d", pointsEarned), 350,10);
    } // end paintComponent
    
    @Override
    public void actionPerformed(ActionEvent e) {
       repaint();
    }
} // end class StatusPanel
