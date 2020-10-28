package Graphing_Calculator.Model_Files;
//prompt user for base and coefficient of exponent, use do while just like in poly but ask for operator between every term (multiply, divide -> add and subtract are done through the coefficients)
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
import javax.swing.*;
import java.awt.*;

import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods
import Graphing_Calculator.Control_Files.GraphCubicControl;

public class GraphExpo extends GraphCubicControl {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphExpo frame = new GraphExpo();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphExpo() { //constructor for initializing labels and textboxes and add them to getcontentpane

    }
}
