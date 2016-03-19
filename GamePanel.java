/****************************************************************************
*   GamePanel.java                                                          *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   creates the panel that will be added to the form                        *
*   handles all the animations for the game                                 *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener,ActionListener{
    
    // variables
    private ArrayList<GameObject> gameObjects;   // list to hold the objects needed for the game
    private SpaceShip spaceShip;                 // holds a SpaceShip object
    private LaserCanon laserCanon;               // holds a LaserCanon object
    private Projectile projectile;               // holds a Projectile object
    private Timer projectileTimer;               // timer for projectile
    private Squadron squadron;                   // holds a Squadron object
    private Timer pointsTimer;                   // timer to determine when points are displayed.
    private StatusPanel statusPanel;             // to update score
    private Alien[][] aliens;                   // holds temp array of aliens
    
    // GUI objects
    private JPanel pnlGame = new JPanel();
    
    // constructors
    public GamePanel() {
        gameObjects = new ArrayList();
        addKeyListener(this);
        projectileTimer = new Timer(50,this);
        pointsTimer = new Timer(100,this);
        statusPanel = new StatusPanel();
        statusPanel.stopUpdateScoreTimer();
        
        
        // createing and adding objects to list
        laserCanon = new LaserCanon(50,50);
        spaceShip = new SpaceShip(this);
        projectile = new Projectile();
        squadron = new Squadron(this);
        gameObjects.add(laserCanon);
        gameObjects.add(spaceShip);
        aliens = squadron.getAliens();
        for (int outer=0;outer<5;outer++){
            for (int inner=0;inner<12;inner++){
                gameObjects.add(squadron.getSpecificAlien(outer,inner));
            } // end inner for loop
        } // end outer for loop
        //squadron.getMoveTimer().start();

    } // end no-arg constructor
    
    // getters and setters
    public ArrayList<GameObject> getGameObjects() {
        return gameObjects;
    } // end getGameObjects

    public void setGameObjects(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    } // end setGameObjects

    public SpaceShip getSpaceShip() {
        return spaceShip;
    } // end getSpaceShip

    public void setSpaceShip(SpaceShip spaceShip) {
        this.spaceShip = spaceShip;
    } // end setSpaceShip

    public LaserCanon getLaserCanon() {
        return laserCanon;
    } // end getLaserCanon

    public void setLaserCanon(LaserCanon laserCanon) {
        this.laserCanon = laserCanon;
    } // end setLaserCanon

    public Projectile getProjectile() {
        return projectile;
    } // end getProjectile

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    } // end setProjectile

    public Timer getProjectileTimer() {
        return projectileTimer;
    } // end getProjectileTimer

    public void setProjectileTimer(Timer projectileTimer) {
        this.projectileTimer = projectileTimer;
    } // end setProjectileTimer

    public Squadron getSquadron() {
        return squadron;
    } // end getSquadron

    public void setSquadron(Squadron squadron) {
        this.squadron = squadron;
    } // end setSquadron
    
    // return panel to add to gameFrame
    public JPanel getPnlGame(){
        return pnlGame;
    } // end getPnlGame
    
    // additional methods
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.black);
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isVisible()){
                gameObject.draw(g);
                if (projectile.isVisible()){
                    if (gameObject instanceof Invader){
                        collision((Invader)gameObject);                       
                    }

                } // end if
            } //end if

        } // end for loop
       // squadron.getMoveTimer().start();
    } // end paintComponent
    
    public String toString() {
        String tempString = "";
        for (GameObject gameObject : gameObjects) {
            tempString += gameObject.toString();
        } // end for loop
        return tempString +", " +projectileTimer;
    } // end toString
    
    // keyboard listener methods
    public void addNotify(){
        super.addNotify();
        requestFocus();
    } // end method addNotify
    
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                if (laserCanon.getLocation().x - laserCanon.getMoveInc() > 0)
                    {laserCanon.setLocation(new Point(laserCanon.getLocation().x - laserCanon.getMoveInc(),laserCanon.getLocation().y));}
                else
                    {laserCanon.setLocation(new Point(0,laserCanon.getLocation().y));}
                repaint();
                break;
            case KeyEvent.VK_RIGHT:
                if (laserCanon.getMoveInc() + laserCanon.getLocation().x < 800 - laserCanon.getWidth())
                    {laserCanon.setLocation(new Point(laserCanon.getMoveInc() + laserCanon.getLocation().x,laserCanon.getLocation().y));}
                else
                    {laserCanon.setLocation(new Point(785 - laserCanon.getWidth(),laserCanon.getLocation().y));}
                repaint();
                break;
            case KeyEvent.VK_SPACE:
                        projectile.setVisible(true);
                        if(projectileTimer.isRunning()){
                           break;
                        }
                        projectile.setLocation(new Point((laserCanon.getLocation().x+(laserCanon.getLocation().x+laserCanon.getWidth()))/2,laserCanon.getLocation().y-6));
                        startProjectileTimer();
                        gameObjects.add(projectile);
                    break;
        } // end switch
    } // end method keyPressed

    public void actionPerformed(ActionEvent ae){
        projectile.setLocation(new Point(projectile.getLocation().x,projectile.getLocation().y-10));
        if (projectile.getLocation().y-5< 0-6){
            projectileTimer.stop();            
        } // end if
        repaint();
    } // end actionPerformed
    
    private void startProjectileTimer(){
        projectileTimer.start();
    } // end startProjectileTimer

    public void collision(Invader object) {
        if(projectile.getBounds().intersects(object.getBounds())){
            projectileTimer.stop();
            projectile.setVisible(false);
            object.setVisible(false);
            if (object instanceof Invader){
                statusPanel.addPointsEarned(object.getPointValue());
                if(object instanceof Alien){
                    squadron.setNumVisible(squadron.getNumVisible()-1);
                }

                if (squadron.getNumVisible() == 0){
                    for(GameObject gameObject : gameObjects){
                        if (gameObject instanceof Alien) {
                            gameObject.setVisible(true);
                        } // end if
                    } // end for
                    squadron.setNumVisible(60);
                } // end if                
            }

        } // end if
    }
} // end class GamePanel
