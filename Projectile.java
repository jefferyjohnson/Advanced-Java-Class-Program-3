/****************************************************************************
*   Projectile.java                                                         *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   inherits from game object class, creates projectile object              *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Projectile extends GameObject{
    
    // variables
    private int speed;  // holds speed of object, number of pixels

    
    // constructors
    public Projectile() {
        setBounds(new Rectangle(1000,1000,0,0)); // so it doesn't intersect on creation
    } // end no-arg constructor
    
    // getters and setters
    public int getSpeed() {
        return speed;
    } // end getSpeed

    public void setSpeed(int speed) {
        this.speed = speed;
    } // end setSpeed
    
    public void draw(Graphics g) {
        g.fillRect(getLocation().x,getLocation().y,3,6);
        setBounds(new Rectangle(getLocation().x,getLocation().y,3,6));
    } // end draw
    
    public String toString() {
        return super.toString() +", " +speed;
    } // end toString

} // end class Projectile
