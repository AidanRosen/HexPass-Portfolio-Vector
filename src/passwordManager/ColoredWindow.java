package passwordManager;

import java.awt.*;
import javax.swing.JFrame;

import java.awt.Color;

public class ColoredWindow extends JFrame{

    public ColoredWindow(String password){
        //Uses the parameter above which should be the passTest passed in as the hex password.
        //You MUST define this as a string
        String colorUsed = "#" + password;
        //Because color used has a # the below should work
        //Color myColor = Color.decode("#6365ff")
        //^ base code to be modified for this window generation
        System.out.println("\n\nyour color is " + colorUsed + "\n\n");
        Color myColor = Color.decode(colorUsed);
        //JFrame colors = new JFrame();
        setTitle("Colored window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set background of the JFrame in the beginning!
        getContentPane().setBackground(myColor);
        getContentPane().setForeground(myColor);
        setPreferredSize(new Dimension(550, 300));

        //Notice how Color is the object and .myColor is the data within that object
        getContentPane().setLayout(null);
        pack();
        setVisible(true);

    }
    /*
    public static void main(String password) {
        //Uses the parameter above which should be the passTest passed in as the hex password.
        //You MUST define this as a string
        String colorUsed = "#" + password;
        //Because color used has a # the below should work
        //Color myColor = Color.decode("#6365ff")
        //^ base code to be modified for this window generation
        System.out.println("\n\nyour color is " + colorUsed + "\n\n");
        Color myColor = Color.decode(colorUsed);
        JFrame colors = new JFrame();
        colors.setTitle("Colored window");
        colors.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        colors.setPreferredSize(new Dimension(550, 300));
        colors.getContentPane().setBackground(Color.BLUE);
        colors.getContentPane().setForeground(Color.BLUE);
        //Notice how Color is the object and .myColor is the data within that object
        colors.pack();
        colors.setVisible(true);
    }*/
}