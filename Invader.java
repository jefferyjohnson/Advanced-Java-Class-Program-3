/****************************************************************************
*   Invader.java                                                            *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   Invader is a subclass of GameObject and will have all enemies           *
*   inherit from it                                                         *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import com.sun.javafx.scene.traversal.Direction;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public abstract class Invader extends GameObject{
    
    // variable
    private int pointValue;       // holds point amount when object is hit
    private int speed;            // number of pixels for timer, speed object moves
    private Direction direction;  // direction object is moving
    private int height;           // height of object in pixels
    private int width;            // width of object in pixels
    private Random rand;          // random number generator
    
    // constructors
    public Invader() {
                
    } // end no-arg constructor
    
    // Getters and Setters
    public int getPointValue() {
        return pointValue;
    } // end getPointValue

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    } // end setPointValue

    public int getSpeed() {
        return speed;
    } // end getSpeed

    public void setSpeed(int speed) {
        this.speed = speed;
    } // end setSpeed

    public Direction getDirection() {
        return direction;
    } // end getDirection

    public void setDirection(Direction direction) {
        this.direction = direction;
    } // end setDirection

    public int getHeight() {
        return height;
    } // end getHeight

    public void setHeight(int height) {
        this.height = height;
    } // end setHeight

    public int getWidth() {
        return width;
    } // end getLength

    public void setWidth(int width) {
        this.width = width;
    } // end setLength

    public Random getRand() {
        return rand;
    } // end getRand

    public void setRand(Random rand) {
        this.rand = rand;
    } // end setRand
    
    // additional methods
    public String toString() {
        return super.toString() +", " +pointValue +", " +speed +", " +direction +", " +height +", " +width +", " +rand;
    } // end toString
} // end class Invader
