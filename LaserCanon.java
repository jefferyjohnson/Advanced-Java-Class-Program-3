/****************************************************************************
*   LaserCanon.java                                                         *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   LaserCannon inherits from GameObject, creates LaserCanon object         *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;



public class LaserCanon extends GameObject{ 
    
    // variables
    private int width;      // width of laserCanon panel
    private int height;     // height of laserCanon panel
    private int moveInc;       // number of pixels moved when arrow pressed
       
    // constructors
    public LaserCanon(int pnlWidth,int pnlHeight) {

        super(true,new Point(375,450),Color.WHITE);
        this.width = pnlWidth;
        this.height = pnlHeight;
        moveInc = 15;
        setBounds(new Rectangle(getLocation().x,getLocation().y,width,height));
    } // end constructor with two arguements
    
    // getters and setters
    public int getWidth() {
        return width;
    } // end getPnlWidth

    public void setPnlWidth(int pnlWidth) {
        this.width = pnlWidth;
    } // end setPnlWidth

    public int getPnlHeight() {
        return height;
    } // end getPnlHeight

    public void setPnlHeight(int pnlHeight) {
        this.height = pnlHeight;
    } // end setPnlHeight

    public int getMoveInc() {
        return moveInc;
    } // end getMoveInc

    public void setMoveInc(int moveInc) {
        this.moveInc = moveInc;
    } // end setMoveInc
    
    // additional Methods
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(getLocation().x,getLocation().y, width, height);
        setBounds(new Rectangle(getLocation().x,getLocation().y,width,height));
    } // end draw
    
    public String toString() {
        return super.toString() +", " +width +", " +height +", " +moveInc;
    } // end toString
} // end class LaserCanon
