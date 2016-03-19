/****************************************************************************
*   Main.java                                                               *
*   Jeffery Johnson                                                         *
*   GEEN 165-002                                                            *
*   11/7/2015                                                               *
*                                                                           *
*   the main class creates the form object used for the game                *
*                                                                           *
*                                                                           *
****************************************************************************/
package spaceinvaders;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        createForm();
    } // end method main
    
        private static void createForm() {
        GameFrame gf = new GameFrame();
        gf.setTitle("Space Invaders");
        gf.setSize(800,600);
        gf.setLocationRelativeTo(null);
        gf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gf.setVisible(true);
    } // end createForm
    
} // end class Main
