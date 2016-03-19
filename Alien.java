/****************************************************************************
*   Alien.java                                                              *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   inherits from Invader, creates alien objects used in Squadron class     *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;



public class Alien extends Invader{
    
    // variables
    private int alienType;  // determines which type alien is displayed
        
    // constructors
    public Alien() {
        setColor(Color.WHITE);
        setVisible(true);
    } // end no-arg constructor
    
    // getters and setters
    public int getAlienType() {
        return alienType;
    } // end getAlienType

    public void setAlienType(int alienType) {
        this.alienType = alienType;
    } // end setAlienType
    
    // additional methods
    public void draw(Graphics g) {
                for (int outer=0;outer<5;outer++){
            for (int inner=0;inner<12;inner++){
                if (alienType == 1){
                    g.setColor(Color.WHITE);
                    g.drawOval(getLocation().x,getLocation().y,getWidth(),getHeight());
                    setBounds(new Rectangle(getLocation().x,getLocation().y,getWidth(),getHeight()));
                } // end if
                if (alienType == 2){
                    g.setColor(Color.WHITE);
                    g.drawRect(getLocation().x,getLocation().y,getWidth(),getHeight());
                    setBounds(new Rectangle(getLocation().x,getLocation().y,getWidth(),getHeight()));
                } // end if
                if (alienType == 3){
                    g.setColor(Color.WHITE);
                    g.drawLine(getLocation().x ,getLocation().y,getLocation().x+24,getLocation().y+24);
                    g.drawLine(getLocation().x+24 ,getLocation().y,getLocation().x,getLocation().y+24);
                    setBounds(new Rectangle(getLocation().x,getLocation().y,getWidth(),getHeight()));
                } // end if
            } // end inner for loop
        } // end outer for loop
    } // end draw
    
    public String toString() {
        return super.toString() +", " +alienType;
    } // end toString


} // end class Alien
