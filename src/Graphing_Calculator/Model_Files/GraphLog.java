package Graphing_Calculator.Model_Files;
//ask user for multiplier of log, base and value, do while but ask for operator between every term (multiply, divide -> add and subtract are done through the coefficients)
//use arraylist of jlabels/jtextboxes/doubles; add a double and jlabel and textbox for input whenever user says they want another input (use a dowhile loop)
import javax.swing.*;
import java.awt.*;

import Graphing_Calculator.Control_Files.GraphLogControl;
import Graphing_Calculator.GraphMain; //allows for calling of GraphMain. methods, which is outside the package Model_Files and therefore cannot be called without being imported
import Graphing_Calculator.GraphingCalculatorUI; //allows for calling of GraphingCalculatorUI. methods

public class GraphLog extends GraphLogControl {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GraphLog frame = new GraphLog();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GraphLog() { //constructor for initializing labels and textboxes and add them to getcontentpane

    }
}
