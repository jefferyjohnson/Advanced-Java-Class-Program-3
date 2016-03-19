/****************************************************************************
*   GameObject.java                                                         *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   class that all objects in the game will inherit from                    *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class GameObject {
    
    //variables
    private boolean visible;  // varible if object is visible on panel
    private Point location;   // current location of the objects reference point
    private Color color;      // current color of the object
    private Rectangle bounds;  //holds the bounds for the object
    
    // constructors
    public GameObject() {
        setVisible(true);
    } // end no-arg constructor
    
    public GameObject(boolean visible,Point location,Color color) {
        
        this.visible = visible;
        this.location = location;
        this.color = color;
    } // end constrcutor with all parameters

    // Getters and Setters
    public boolean isVisible() {
        return visible;
    } // end isVisible

    public void setVisible(boolean visible) {
        this.visible = visible;
    } // end setVisible

    public Point getLocation() {
        return location;
    } // end getLocation

    public void setLocation(Point location) {
        this.location = location;
    } // end setLocation

    public Color getColor() {
        return color;
    } // end getColor

    public void setColor(Color color) {
        this.color = color;
    } // end setColor
     
    public Rectangle getBounds() {
        return bounds;
    } // end getBounds

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    } // end setBounds
    
    
    // additional methods
    public abstract void draw(Graphics g); // abstract method for draw
    
    public String toString() {
        return visible +", " +location +", " +color;
    } // end toString
} // end class GameObject
