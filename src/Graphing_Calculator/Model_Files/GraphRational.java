package Graphing_Calculator.Model_Files;
//ui: ask user to enter numberator first: for the coefficient and exponent value, then ask if they want another term or if they want to enter the denominator after they finish entering; then prompt for denominator whenever: use same process as username
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
import javax.swing.*;
import java.awt.*;

import Graphing_Calculator.Control_Files.GraphRationalControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods

public class GraphRational extends GraphRationalControl {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphRational frame = new GraphRational();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphRational() { //constructor for initializing labels and textboxes and add them to getcontentpane

    }
}
