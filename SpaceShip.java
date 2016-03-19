/****************************************************************************
*   SpaceShip.java                                                          *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   Spaceship inherits from Invader class, creates SpaceShip Object         *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class SpaceShip extends Invader implements ActionListener{
    
    // variables
    private Timer moveTimer;     // timer for ship movement
    private Timer launchTimer;   // timer for launching spaceships
    private GamePanel gamePanel; // GamePanel object 
    private Random rand;         // random number generator
    private int direction;       // determine direction of spaceShip
    
    // constructors
    public SpaceShip(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        setColor(Color.WHITE);
        setWidth(50);
        setHeight(40);
        rand = new Random();
        moveTimer = new Timer(50,this);
        launchTimer = new Timer((1+rand.nextInt(8000))*1000,this);
        moveSpaceShip();
        setBounds(new Rectangle(getLocation().x,getLocation().y,getWidth(),getHeight()));
        setPointValue((1+rand.nextInt(6))*50);
        setSpeed(5);
    } // end no-arg contstructor
    
    // additional methods
    public void startMoveTimer() {
        moveTimer.start();
    } // end startMoveTimer
    
    public void stopMoveTimer() {
        moveTimer.stop();
    } // end stopMoveTimer
    
    public void startLaunchTimer() {
        launchTimer.start();
    } // end startLaunchTimer
    public void stopLaunchTimer() {
        launchTimer.stop();
    } // end stopLaunchTimer
    
    public void draw (Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(getLocation().x, getLocation().y, getWidth(), getHeight());
        setBounds(new Rectangle(getLocation().x,getLocation().y,getWidth(),getHeight()));
    } // end draw

    public String toString() {
        return super.toString() +", " +moveTimer +", " +launchTimer +", " +gamePanel +", " +rand;
    } // end toString
    
    private void moveSpaceShip() {
        direction = rand.nextInt(1000);
        if (direction%2 == 0){
            // timer for time of spaceShip to get accross screen
            setLocation(new Point(0-getWidth(),0));
            moveTimer.start();
            setPointValue((1+rand.nextInt(6))*50);
            setVisible(true);

        } // end if
        else {
           // timer for time of spaceShip to get accross screen
            setLocation(new Point(800,0));
            moveTimer.start();
            setPointValue((1+rand.nextInt(6))*50);
            setVisible(true);        

        } // end else
    } // end moveSpaceShip
    private void launchSpaceShip() {
        launchTimer = new Timer(3000+ (rand.nextInt(6)*1000),this);
        launchTimer.start();
    }// end launchSpaceShip
    
    public void actionPerformed(ActionEvent ae) {
        if (direction%2 == 0) {
            setLocation(new Point(getLocation().x+getSpeed(),getLocation().y));
            if (getLocation().x > 800+getWidth()){ 
                moveTimer.stop();
                launchSpaceShip();
                } // end if
            gamePanel.repaint();
        } // end if
        else {
            setLocation(new Point(getLocation().x-getSpeed(),getLocation().y));
            if (getLocation().x < 0-getWidth()){ 
                moveTimer.stop();
                launchSpaceShip();
            } // end if    
            gamePanel.repaint();
        }
        if (launchTimer.isRunning()){
            launchTimer.stop();
            moveSpaceShip();
        }
    }

} // end class SpaceShip
