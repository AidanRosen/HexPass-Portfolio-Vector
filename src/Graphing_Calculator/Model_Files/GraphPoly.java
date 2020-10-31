package Graphing_Calculator.Model_Files;
//ui: ask user for the coefficient and exponent value, then ask if they want another term after they finish entering
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Graphing_Calculator.Control_Files.GraphPolyControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods

public class GraphPoly extends JFrame {

    public static void main(String[] args) {

        /*
        initialize textfields (magXInput, magYInput, smoothInput) and labels prompts for xmag, ymag, smoothness and doubles to assign each of these inputs to -> use try catch to make sure that user inputted a number for everything.
        initialize textfield coef: for entering coefficent, setbounds to in front of xlabel
        initialize jlabel xlabel: "x"
        initialize textfield exp: for entering exponent, setbounds to behind xlabel
        initialize jbutton graphButton: calls the graph function; add actionlistener which saves the values in xmag, ymag and smoothness to the doubles and calls graph()-> this actionlistener has to be done in this file
        initialize jbutton enterNext: saves values of user inputted data from textfields (String coefficient = coef.getText()), add actionlistener which saves value of user inputs using a method in control into the arraylists for coefficient and exponent; then resets the textfields to blank ->actionslistener to be declared in control file
        initialize 2 arraylists of doubles for storing user input of coefficients and exponents ->I don't know the exact syntax to declaring an arrylist, Ill search it up later
        //arraylists are basically arrays but they can expand freely as more values are added, whereas arrays must have a fixed size
        initialize jlabels for xint and yint display
        */
        EventQueue.invokeLater(() -> {
            try {
                GraphPoly frame = new GraphPoly(); //calls constructor and constructor of jframe to create a new window
                //constructor of jframe is also called as this class is extended from jframe, meaning jframe is the parent class. Whenever a constructor is called, the parent class' constructor will also be called automatically.
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphPoly() { //constructor for initializing labels and textboxes and add them to getcontentpane
        /*
            setbounds of textfields/buttons/jlabels

            graphButton.addActionListener(new ActionListener() { //initialize actionlistener for graph button
            @Override
            public void actionPerformed(ActionEvent e) {
                if (magX != null && magY != null && smoothness != null) {
                    Graph(arraylist for coef, arrlist for exp, magX, magY, smoothness);
                }
            }

            GraphPolyControl.enterNextActionListener(); //calls for creation of actionlistener for enter next button, which can be done in the control file unlike actionlistener for graph button which has to made in this file as graph() cannot be made static and therefore cannot be accessed from other files
        });
         */
    }

    /*public void Graph(arraylist, arraylist, double, double, double) {
        double domainLower = -50.0 * magX;
        double domainUpper = 50.0 * magX;
        double rangeLower = -50.0 * magY;
        double rangeUpper = 50.0 * magY;
        double y = 0; //stores y-output
        arraylist of doubles for approx x-ints;
        double for y-int;

        for (double x = domainLower; x < domainUpper; x += smoothness * magX) { //Graphs into a 2d array
            for (int i = 0; i < arraylist.length, i++) { //reads values from arraylists: if first user inputted value was -3x^5, then i = 0 and arraylistcoef = -3 and arraylistexp = 5
                y += arraylistcoef * (x)^arraylistexp;
                //eg. arraylistcoef = {3, -1, 5} and arraylistexp = {4, 6, 0}
                //meaning user is trying to graph 3x^4 - 1x^6 + 5
                //if x currently equals 2.0:
                //i = 0:
                //y += 3(2.0)^4; y = 48
                //i = 1:
                //y += -1(64.0)^6; y = -16
                //i = 2:
                //y += 5(2.0)^0; y = -11
                //so the point going into the 2d array is (2, -11) or [52][61] in 2d array terms given that the axes are at 50
            }

            if (Math.abs(y) < rangeUpper && Math.abs(y) > rangeLower) { //puts x,y coordinates into 2d array
                GraphMain.Graph[50 - (int) Math.round((y / magY))][50 + (int) Math.round((x / magX))].setText("0"); //inputs into array scaled based on magnitude (eg if mag is 0.1 then each space in the graph/array is equal to 0.1 instead of 1/zooms in by 10x into the graph
                //50 is the axes
                //eg if y is -20, the program puts a 0 in the 2d array at row 50 - (-20) = row 70 from the top
                //if x is 10, the program puts a 0 in column 50 + 10 = column 60 of the 2d array
                //so "0" is inserted at (60, 70) or (10, -20) in graphical terms

                if (y == 0) { //approx x-intercept
                   arraylistxint.put(x); //stores current x-value as an x-int
                }

                if (x == 0) { //approx y-int
                    yint = y;
                }
            }
        }

        GraphingCalculatorUI.main(null); //prints out graph
        iterate through arraylistxint and put all xints on a jlabel
        put yint onto anoth jlabel
    }
     */
}
