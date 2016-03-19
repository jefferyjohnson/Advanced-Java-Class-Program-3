/****************************************************************************
*   Squadron.java                                                           *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   creates a 2-D array of alien objects                                    *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import com.sun.javafx.scene.traversal.Direction;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Squadron extends Alien implements ActionListener{
    
    // variables
    private Alien[][] aliens = new Alien[5][12]; // 2-d array to hold alien objects
    private Direction direction;                 // direction the aliens will move
    private Timer moveTimer;                     // timer for movement of squadron
    private int numVisible;                      // number of aliens that need to be destroyed
    private GamePanel gamePanel;                 // used to display the squadron and get boundries
    
    // constructors
    public Squadron() {
        
    } // end no arg constructor
    public Squadron(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        numVisible = 60;
        moveTimer = new Timer(50,this);
        setColor(Color.WHITE);
        setVisible(true);
        
        // create the aliens for the squadron
        for (int outer=0;outer<5;outer++){
            for (int inner=0;inner<12;inner++){
                if (outer == 0){
                    aliens[outer][inner] = new Alien();
                    aliens[outer][inner].setAlienType(1);
                    aliens[outer][inner].setPointValue(40);
                    aliens[outer][inner].setSpeed(3);
                    aliens[outer][inner].setWidth(24);
                    aliens[outer][inner].setHeight(24);
                    aliens[outer][inner].setVisible(true);
                    aliens[outer][inner].setColor(Color.WHITE);
                    aliens[outer][inner].setLocation(new Point(((inner*(aliens[outer][inner].getWidth()+15))+15),75+outer*(aliens[outer][inner].getHeight()+15)));
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                    
                } // end if
                if (outer == 1 || outer == 2){
                    aliens[outer][inner] = new Alien();
                    aliens[outer][inner].setAlienType(2);
                    aliens[outer][inner].setPointValue(20);
                    aliens[outer][inner].setSpeed(3);
                    aliens[outer][inner].setWidth(24);
                    aliens[outer][inner].setHeight(24);
                    aliens[outer][inner].setVisible(true);
                    aliens[outer][inner].setColor(Color.WHITE);
                    aliens[outer][inner].setLocation(new Point(((inner*(aliens[outer][inner].getWidth()+15))+15),75+outer*(aliens[outer][inner].getHeight()+15)));
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                } // end if
                if (outer == 3 || outer == 4){
                    aliens[outer][inner] = new Alien();
                    aliens[outer][inner].setAlienType(3);
                    aliens[outer][inner].setPointValue(10);
                    aliens[outer][inner].setSpeed(3);
                    aliens[outer][inner].setWidth(24);
                    aliens[outer][inner].setHeight(24);
                    aliens[outer][inner].setVisible(true);
                    aliens[outer][inner].setColor(Color.WHITE);
                    aliens[outer][inner].setLocation(new Point(((inner*(aliens[outer][inner].getWidth()+15))+15),75+outer*(aliens[outer][inner].getHeight()+15)));
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                } // end if
            } // end inner for loop
        } // end outer for loop
    } // end constructor with argument
    
    // getters and setters
    public Alien[][] getAliens() {
        return aliens;
    } // end getAliens

    public void setAliens(Alien[][] aliens) {
        this.aliens = aliens;
    } // end setAliens

    public Direction getDirection() {
        return direction;
    } // end getDirection

    public void setDirection(Direction direction) {
        this.direction = direction;
    } // end setDirection

    public Timer getMoveTimer() {
        return moveTimer;
    } // end getMoveTimer

    public void setMoveTimer(Timer moveTimer) {
        this.moveTimer = moveTimer;
    } // end setMoveTimer

    public int getNumVisible() {
        return numVisible;
    } // end getNumVisible

    public void setNumVisible(int numVisible) {
        this.numVisible = numVisible;
    } // end setNumVisible

    public GamePanel getGamePanel() {
        return gamePanel;
    } // end getGamePanel

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    } // end setGamePanel
    
    // return specific alien
    public Alien getSpecificAlien(int row,int column){
        return aliens[row][column];
    }
    // additional methods
    public void draw(Graphics g) {
        
        for (int outer=0;outer<5;outer++){
            for (int inner=0;inner<12;inner++){
                if (aliens[outer][inner].getAlienType() == 1){
                    g.setColor(Color.WHITE);
                    g.drawOval(aliens[outer][inner].getLocation().x+12,aliens[outer][inner].getLocation().y+12,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight());
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                } // end if
                if (aliens[outer][inner].getAlienType() == 2){
                    g.setColor(Color.WHITE);
                    g.drawRect(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight());
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                } // end if
                if (aliens[outer][inner].getAlienType() == 3){
                    g.setColor(Color.WHITE);
                    g.drawLine(aliens[outer][inner].getLocation().x , aliens[outer][inner].getLocation().y, aliens[outer][inner].getLocation().x+24, aliens[outer][inner].getLocation().y+24);
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                } // end if
            } // end inner for loop
        } // end outer for loop
    } // end draw
    
    public String toString() {
        String tempString = "";
        for (int outer = 0;outer < 5;outer++) {
            for (int inner=0; inner <12; inner++) {
                tempString += aliens[outer][inner].toString();
            } // end inner for loop
        } // end outer for loop
        return tempString +", " +direction +", " +moveTimer +", " +gamePanel;
    } // end toString 

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int outer=0;outer<5;outer++){
            for (int inner=0;inner<12;inner++){
                if (outer == 0){
                    aliens[outer][inner].setLocation(new Point((inner*(aliens[outer][inner].getWidth()+15+aliens[outer][inner].getSpeed())),75+outer*(aliens[outer][inner].getHeight()+15)));
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                    
                } // end if
                if (outer == 1 || outer == 2){
                    aliens[outer][inner].setLocation(new Point((inner*(aliens[outer][inner].getWidth()+15+aliens[outer][inner].getSpeed())),75+outer*(aliens[outer][inner].getHeight()+15)));
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                } // end if
                if (outer == 3 || outer == 4){
                    aliens[outer][inner].setLocation(new Point((inner*(aliens[outer][inner].getWidth()+15+aliens[outer][inner].getSpeed())),75+outer*(aliens[outer][inner].getHeight()+15)));
                    aliens[outer][inner].setBounds(new Rectangle(aliens[outer][inner].getLocation().x,aliens[outer][inner].getLocation().y,aliens[outer][inner].getWidth(),aliens[outer][inner].getHeight()));
                } // end if
            } // end inner for loop
        } // end outer for loop
        gamePanel.repaint();
    }
} // end class Squadron
